package 다시풀기;

import java.util.*;
import java.io.*;

public class boj11724 {

    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++){
            //i와 연결 돼 있는 정점이 모두 dfs 호출로 인해 방문됨
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }


        System.out.println(answer);
    }

    static void dfs(int idx){

        visited[idx] = true;

        for(int i=0; i<graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }

    }

}
