package 탐색과정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {

    final static int MAX = 100000+10;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, R;
    static int[] answer;
    static int order;

//    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());



        graph = new ArrayList[MAX];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[MAX];
        answer = new int[MAX];

        int u,v;

        //그래프 정보 채우기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }


        //오름차순 정렬렬
       for(int i= 1; i<=N; i++){
           Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i=1; i<=N; i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    public static void dfs(int idx){

        visited[idx] = true;
        order++;
        answer[idx] = order;

        for(int i=0; i< graph[idx].size(); i++){
            if(!visited[graph[idx].get(i)]){
                dfs(graph[idx].get(i));
            }
        }
    }
}
