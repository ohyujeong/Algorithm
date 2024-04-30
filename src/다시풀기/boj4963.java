package 다시풀기;

import java.util.*;
import java.io.*;

public class boj4963 {

    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1,1,-1,1,-1};
    static int[] dy = {-1,1,0,0,1,-1,-1,1};

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=h || ny<0 || ny>=w){
                continue;
            }

            if(map[nx][ny]==1 && !visited[nx][ny]){
                dfs(nx,ny);
            }

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            // 1->땅 0->바다
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        answer++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(answer);


        }
    }
}
