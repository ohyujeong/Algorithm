package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480 {

    final static int MAX = 100000+10;

    static int N,M,R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int order;
    static int[] answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        visited = new boolean[MAX];
        answer = new int[MAX];
        graph = new ArrayList[MAX];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }


        int u,v;

        //그래프 정보 채우기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        //내림차순 정렬
        for(int i= 1; i<=N; i++){
//            Collections.sort(graph[i],Collections.reverseOrder());
            graph[i].sort(Collections.reverseOrder());
        }

        dfs(R);

        for(int i=1; i<=N; i++){
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);

    }

    public static void dfs(int idx){

        visited[idx] = true;
        order++;
        answer[idx] = order;

        for(int i=0; i< graph[idx].size(); i++){
            int nextNode = graph[idx].get(i);
            if(!visited[nextNode]){
                dfs(graph[idx].get(i));
            }
        }

    }
}
