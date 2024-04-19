package DFS;

import java.util.*;
import java.io.*;

public class boj2468 {

    static int N;
    static int[][] map;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static boolean[][] visited;
    static int maxRain = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxRain = Math.max(maxRain, map[i][j]);
            }
        }

        int ans = 0;
        for(int h=0; h<=maxRain; h++){
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    //안전구역 개수 세기
                    if(!visited[i][j] && map[i][j]>h){
                        cnt+=dfs(i,j,h);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static int dfs(int x, int y, int h){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny]>h){
                dfs(nx,ny,h);
            }
        }
        return 1;
    }



}
