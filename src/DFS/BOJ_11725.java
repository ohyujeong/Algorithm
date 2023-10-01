package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {

    static ArrayList<Integer>[] graph;
    static int N;
    static int[] answer;
    static boolean[] visited;

    public static void dfs(int idx){

        //방문했으니까 true로 바꿔줌
        visited[idx] = true;

        for(int i=0; i<graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                //다음에 방문할 노드(next)의 부모가 현재노드(idx)니까 answer에 담아줌
                answer[next] = idx;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+10];

        //graph 초기화 연결 정보 채우기
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N+10];
        answer = new int[N+10];


        int x,y;

        //문제에서 N-1개의 간선이 들어올거라 했으니까 N-1까지
        for (int i=0; i< N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        //dfs 호출
        dfs(1);

        for(int i=2; i<=N; i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

}
