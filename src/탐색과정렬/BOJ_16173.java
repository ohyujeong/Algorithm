package 탐색과정렬;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16173 {

    //map에 들어갈 수 있는 최대값 100 고려
    static final int MAX = 3 + 110;

    static int[][] map;
    static boolean[][] visited;
    static int dirY[] = {1,0};
    static int dirX[] = {0,1};
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        map = new int [MAX][MAX];
        visited = new boolean[MAX][MAX];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,1);

        if(visited[N][N]){
            bw.write("HaruHaru");
        }
        else{
            bw.write("Hing");
        }

        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {

        visited[y][x] = true;

        if(y == N && x == N){
            return;
        }

        //방향이 2가지(오른쪽,아래) 이기 때문에 2까지만 i 반복
        for(int i=0; i<2; i++){
            int newY = y + dirY[i] * map[y][x];
            int newX = x + dirX[i] * map[y][x];
            if(!visited[newY][newX]){
                dfs(newY,newX);
            }
        }
    }

}
