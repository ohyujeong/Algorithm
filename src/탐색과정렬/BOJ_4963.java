package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {

    final static int MAX = 50 + 10;

    static int W,H;
    static boolean[][] map;

    //상하좌우 + 대각선까지
    static int[] dirY = {-1,-1,0,1,1,1,0,-1};
    static int[] dirX = {0,1,1,1,0,-1,-1,-1};

    public static void dfs(int y, int x){

        map[y][x] = false;

        //8개의 방향 탐색
        for(int i=0; i<8; i++){
            int newY = y +dirY[i];
            int newX = x + dirX[i];
            if(map[newY][newX]){
                dfs(newY,newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            //마지막 줄에 0,0
            if(W==0 && H==0){
                break;
            }

            map = new boolean[MAX][MAX];

            //map 채우기

            for(int i=1; i<=H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=W; j++){
                    //1이면 true, 아니면 false 담음
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }

            //dfs
            int answer = 0;
            for(int i=1; i<=H; i++){
                for(int j=1; j<=W; j++){
                    if(map[i][j]){
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            //출력
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
