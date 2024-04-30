package 다시풀기;

import java.io.*;
import java.util.*;

public class boj1388 {

    static int MAX = 50+10;
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static void dfs(int x, int y){

        visited[x][y] = true;

        //어차피 앞에서부터 차례대로 탐색하니까 -1 은 고려해주지 않아도 됨
        if(map[x][y]=='-'&& map[x][y+1]=='-'){
            dfs(x,y+1);
        }
        else if(map[x][y]=='|' && map[x+1][y]=='|'){
            dfs(x+1,y);
        }

    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    answer++;
                }
            }
        }


        System.out.println(answer);

    }
}
