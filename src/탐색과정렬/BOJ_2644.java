package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2644 {

    static int N, start, end, M, answer;

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        //오름차순 정렬
        for(int i= 1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        answer = -1;

        //start와 idx가 몇촌 사이인지를 나타내는 count
        dfs(start,0);
        System.out.println(answer);

    }

    public static void dfs(int idx, int count){

        visited[idx] = true;

        if(idx == end){
            answer = count;
            return;
        }

        for(int i=0; i< graph[idx].size(); i++){
            int nextNode = graph[idx].get(i);
            if(!visited[nextNode]){
                dfs(graph[idx].get(i), count+1);
            }
        }
    }
}
