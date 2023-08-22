package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13565 {

    final static int MAX = 1000+10;
    static int N,M;
    static boolean[][] map;

    static int[] dirY = {-1,1,0,0};
    static int[] dirX = {0,0,-1,1};

    static boolean answer;

    public static void dfs(int y, int x){

        if(y==N){
            answer = true;
            return;
        }

        map[y][x] = false;

        for(int i=0; i<4; i++){
            int newY = y+dirY[i];
            int newX = x+dirX[i];
            if(map[newY][newX]){
                dfs(newY,newX);
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        map = new boolean[MAX][MAX];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                //str의 인덱스는 0부터 M-1까지니까 j-1로 접근
                //j-1 char가 0이라면, true 0이 아니라면 false
                map[i][j] = (str.charAt(j - 1) == '0' ? true : false);
            }
        }

        //가로줄에 있는 전류가 흐르는(1) 부터 탐색
        for(int j=1; j<=M; j++){
            if(map[1][j]){
                dfs(1,j);
            }
        }

        if(answer){
            sb.append("YES");
            System.out.println(sb);
        }
        else{
            sb.append("NO");
            System.out.println(sb);
        }
    }

}
