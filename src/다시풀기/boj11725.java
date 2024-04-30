package 다시풀기;

import java.util.*;
import java.io.*;

public class boj11725 {

    static int n;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] answer;

    static void dfs(int idx){

        visited[idx] = true;

        for(int i=0; i<tree[idx].size(); i++){
            int next = tree[idx].get(i);
            if(!visited[next]){
                answer[next] = idx;
                dfs(next);
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        answer = new int[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);

    }
}
