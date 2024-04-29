package 다시풀기;

import java.util.*;
import java.io.*;

public class boj2644 {

    static int n,m;
    static int p1,p2;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(p1,0);

        System.out.println(answer);
    }

    static void dfs(int idx, int cnt){

        visited[idx] = true;

        if(idx==p2){
            answer=cnt;
            return;
        }

        for(int i=0; i<graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                dfs(next, cnt+1);
            }
        }
    }
}
