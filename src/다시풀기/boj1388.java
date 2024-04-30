package 다시풀기;

import java.io.*;
import java.util.*;

public class boj1388 {

    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dir = {1,-1};

    static void dfs(int x, int y, boolean flag){

        visited[x][y] = true;

        //- 탐색
        if(flag){
            //y값만 변화하면서 탐색 -> 같은 행에 있어야 하니까
            for(int i=0; i<2; i++){
                int ny = y+dir[i];
                if(ny<0 || ny>=M){
                    continue;
                }
                if(map[x][ny]=='-' && !visited[x][ny]){
                    dfs(x,ny,true);
                }
            }
        }

        // | 탐색
        else{
            //x값만 변화
            for(int i=0; i<2; i++){
                int nx = x+dir[i];
                if(nx<0 || nx>=N){
                    continue;
                }
                if(map[nx][y]=='|' && !visited[nx][y]){
                    dfs(nx,y,false);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    if(map[i][j]=='-'){
                        dfs(i,j,true);
                    }
                    else{
                        dfs(i,j,false);
                    }
                    answer++;
                }
            }
        }


        System.out.println(answer);

    }
}
