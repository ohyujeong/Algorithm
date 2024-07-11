package 다시풀기;

import java.util.*;
import java.io.*;

public class boj14052 {

    static int n,m;
    static int[][] map;

    static int answer = 0;

    static int[] dx= {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static void dfs(int depth){

        //벽 3개 다 세우면 바이러스 퍼뜨리기
        if(depth==3){
            spreadVirus();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    //빈 칸(0)에 벽(1) 세워줌
                    map[i][j]=1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }

    //2. 벽 3개 세웠을 때마다 바이러스 퍼뜨리고
    static void spreadVirus(){

        //오리지널 map은 dfs 탐색 돌아야 하니까 copy map 만들어서 바이러스 퍼뜨림
        int[][] copyMap = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMap[i][j] = map[i][j];
                if(copyMap[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        //바이러스 상하좌우로 바이러스 퍼뜨림
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || copyMap[nx][ny]!=0){
                    continue;
                }

                copyMap[nx][ny]=2;
                q.offer(new int[]{nx,ny});

            }
        }

        //3. 바이러스 다 퍼뜨린 후 안전구역 카운팅해서 max값을 answer에 저장
        int safeZone = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j]==0){
                    safeZone++;
                }
            }
        }

        answer = Math.max(answer, safeZone);

    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //세로 크기
        n = Integer.parseInt(st.nextToken());
        //가로 크기
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //1. 벽을 세우는 경우의 수
        dfs(0);


        System.out.println(answer);
    }
}
