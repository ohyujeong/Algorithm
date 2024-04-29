package 다시풀기;

import java.util.*;
import java.io.*;

public class boj24479 {

    static int N,M,R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int depth = 1;

    static void dfs(int idx){

        visited[idx] = true;
        answer[idx] = depth;

        for(int i=0; i<graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                depth++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];
        answer = new int[N+1];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i=1; i<=N; i++){
            if(visited[i]){
                System.out.println(answer[i]);
            }
            else{
                System.out.println(0);
            }
        }

    }
}
