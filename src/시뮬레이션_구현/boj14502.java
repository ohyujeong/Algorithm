package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//연구소
public class boj14502 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int n,m;
    static int[][] map;
    static int ans = 0;
    static int wall = 3;

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

    public static void dfs(int depth){

        //벽이 3개 설치된 경우 bfs로 안전구역 개수 카운팅
        if(depth==wall){
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

    public static void bfs(){

        //원래 map은 계속 dfs탐색 돌아야 하니까 copy를 만들어서 바이러스 퍼뜨리며 개수를 세어줌
        int[][] copyMap = new int[n][m];
        for(int i=0; i<n; i++){
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m || copyMap[nx][ny]!=0){
                    continue;
                }

                copyMap[nx][ny] = 2;
                q.offer(new int[]{nx,ny});
            }
        }
        cntSafeZone(copyMap);
    }

    public static void cntSafeZone(int[][] copyMap){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j]==0){
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

}
