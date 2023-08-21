package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {

    final static int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int T, N, M, K;

    //상하좌우 탐색하기 위한 변수
    static int dirY[] = {-1,1,0,0};
    static int dirX[] = {0,0,-1,1};

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int newY = y+dirY[i];
            int newX = x+dirX[i];
            if(map[newY][newX] && !visited[newY][newX]){
                dfs(newY,newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                //0,0말고 1,1부터 시작
                map[y + 1][x + 1] = true;
            }

            //dfs
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    //배추가 존재하고 아직 방문하지 않았다면
                    if(map[i][j] && !visited[i][j]){
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
