package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {

    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;


    public static void dfs(int idx){
        visited[idx] = true;

        for(int i=0; i< tree[idx].size(); i++){
            int nextNode = tree[idx].get(i);
            if(!visited[nextNode]){
                answer[nextNode] = idx;
                dfs(tree[idx].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }


        int x,y;

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1);

        for(int i=2; i<=N; i++){
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);

    }

}
