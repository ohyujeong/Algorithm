package 다시풀기;

import java.util.*;
import java.io.*;

public class boj14502_2 {

    static int N,M;
    static int[][] map;
    static int answer = 0;

    //dfs에 사용할 벽을 세울 수 있는 빈 칸 좌표와 벽 세웠는지 안 세웠는지 check 배열
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[] check;
    static ArrayList<int[]> wall = new ArrayList<>();


    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    //1. 벽을 세울 수 있는 경우의 수
    static void dfs(int depth, int start){

        //벽 3개 다 세우면 바이러스 퍼뜨림
        if(depth==3){
            bfs();
            return;
        }

        // 벽 세울 수 있는 좌표인 list 순회하면서 벽 세웠으면 check true 표시
        for(int i=start; i<list.size(); i++){
            if(!check[i]){
                check[i]=true;
                //벽 세운 다음 좌표부터 다시 start해서 벽 세울 수 있는 지 검사
                wall.add(list.get(i));
                dfs(depth+1, i+1);
                wall.remove(list.get(i));
                check[i]=false;
            }
        }
    }

    //2. 바이러스 퍼뜨리기
    static void bfs(){

        int[][] copyMap = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copyMap[i][j] = map[i][j];
                if(copyMap[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        for(int i=0; i<3; i++){
            int x = wall.get(i)[0];
            int y = wall.get(i)[1];
            copyMap[x][y] = 1;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || copyMap[nx][ny]!=0){
                    continue;
                }
                copyMap[nx][ny]=2;
                q.offer(new int[]{nx,ny});
            }
        }


        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j]==0){
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, cnt);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }

        check = new boolean[list.size()];
        dfs(0,0);

        System.out.println(answer);

    }
}
