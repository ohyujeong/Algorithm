package 다시풀기;

import java.util.*;
import java.io.*;

public class boj14503 {

    static int N,M;
    static int[][] map;

    static int r,c,d;

    //반시계방향으로 회전..
    //북->서->남->동
    //((d+3)%4)

    //후진
    //북->남 (0->2), (2->0)
    //동->서 (1->3), (3->1)
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int answer = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new int[]{r,c});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean flag = false;
            if(map[cur[0]][cur[1]]==0){
                map[cur[0]][cur[1]]=-1;
                answer++;
            }
            //주변 4칸에 청소되지 않은 빈칸 있는 지 탐색
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==1 || map[nx][ny]==-1){
                    continue;
                }
                //청소되지 않은 빈 칸 있다면 전진할 때 까지 회전하고 for문 탐색 종료
                clean(cur[0], cur[1]);
                flag = true;
                break;
            }

            //주변 4칸에 청소되지 않은 빈 칸 없는 경우
            if(!flag){
                //방향 유지한 채로 한 칸 후진 할 수 있으면 후진
                int dir = (d+2)%4;
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==1){
                    break;
                }
                q.offer(new int[]{nx,ny});
            }

        }


        System.out.println(answer);
    }

    static void clean(int x, int y){
        while(true){
            //반시계 방향 회전
            d+=3;
            int dir = d%4;
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            //앞쪽이 청소되지 않은 빈칸이면 전진
            if(check(nx,ny)){
                q.offer(new int[]{nx,ny});
                break;
            }
        }
    }

    static boolean check(int x,int y){
        if(x<0 || y<0 || x>=N || y>=M || map[x][y]==1 || map[x][y]==-1){
            return false;
        }
        return true;
    }
}
