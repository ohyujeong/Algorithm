package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        int x,y;

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;

        }


        //1번 컴퓨터부터 호출출
        dfs(1);

        sb.append(answer-1);

        System.out.println(sb);
        br.close();;
    }

    public static void dfs(int index){

        //방문한 컴퓨터 true로 바꿔줌
        visited[index] = true;
        answer++;

        //재귀호출
        for(int i=1; i<=N; i++){
            //방문하지 않고 index컴퓨터랑 i번 컴퓨터가 연결되어 있다면
            if(!visited[i] && graph[index][i]){
                dfs(i);
            }
        }
    }
}
