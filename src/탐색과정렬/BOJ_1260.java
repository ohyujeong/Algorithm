package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {

    static int MAX = 1000+10;
    static int N,M,V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX];

        graph = new ArrayList[MAX];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        int x,y;
        //그래프 정보 채우기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i= 1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);
        sb.append('\n');

        visited = new boolean[MAX];
        bfs();

        System.out.println(sb);
    }


    public static void dfs(int depth){

        visited[depth] = true;
        sb.append(depth).append(' ');

        for(int i=0; i<graph[depth].size(); i++){
            int next = graph[depth].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()){
           int temp = queue.poll();
           sb.append(temp).append(' ');

//            System.out.println("what: ? " + graph[temp]);
            for(int next : graph[temp]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}
