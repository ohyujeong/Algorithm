package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {

    final static int MAX = 1000+10;

    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        int u,v;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        for(int i=1; i<=N; i++){
            //한 번 탐색하면 i와 관련된 노드는 모두 true가 됨 얘네가 하나의 덩어리니까 +1해주기..
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        sb.append(answer);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int index){
        //방문한 컴퓨터 true로 바꿔줌
        visited[index] = true;
        //재귀호출
        for(int i=1; i<=N; i++){
            //방문하지 않고 index컴퓨터랑 i번 컴퓨터가 연결되어 있다면
            if(!visited[i]&& graph[index][i]){
                dfs(i);
            }
        }
    }
}
