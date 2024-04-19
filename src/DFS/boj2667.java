package DFS;

import java.io.*;
import java.util.*;

public class boj2667 {

    static int n;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt;
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    static void dfs(int x, int y){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]){
                continue;
            }
            if(map[nx][ny]==1){
                visited[nx][ny] = true;
                cnt++;
                dfs(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j]==1){
                    cnt = 1;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }

    }
}
