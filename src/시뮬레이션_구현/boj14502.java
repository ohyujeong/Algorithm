package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//연구소
public class boj14502 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int n,m;
    static int[][] map;
    static int ans=0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    //벽을 3개 세우는 경우 dfs로 완탐
    static void dfs(int depth){

        if(depth==3){
            //바이러스를 bfs로 퍼뜨림
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }

    }

    static void bfs(){

        Queue<int[]> q = new LinkedList<>();

        int[][] virus = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                virus[i][j] = map[i][j];
                if(virus[i][j]==2){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }

                if(!visited[nx][ny] && virus[nx][ny]==0){
                    virus[nx][ny]=2;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        cntSafeZone(virus);

    }

    static void cntSafeZone(int[][] map){

        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    cnt++;
                }
            }
        }

        ans = Math.max(ans,cnt);
    }
}
