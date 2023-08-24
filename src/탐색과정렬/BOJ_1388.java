package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {


    final static int MAX = 50 + 10;
    static int N,M;
    static char[][] map;
    static boolean[][] visited;

    public static void dfs(int y, int x){

        visited[y][x] = true;

        if(map[y][x] == '-' && map[y][x+1] == '-'){
            dfs(y, x+1);
        }
        if(map[y][x] == '|' && map[y+1][x] == '|'){
            dfs(y+1,x);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];


        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = str.charAt(j-1);
            }
        }

        int answer =0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    answer++;
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

}
