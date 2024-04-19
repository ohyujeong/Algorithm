package DFS;

import java.util.*;
import java.io.*;

public class boj2644 {

    static int n,m;
    static int target, start;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static int ans = -1;

    static void dfs(int idx, int cnt){
        visited[idx] = true;
        if(idx==target){
            ans=cnt;
            return;
        }
        for(int i=0; i<graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(!visited[next]){
                dfs(next, cnt+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        int x,y;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(graph[i]);
        }

        dfs(start, 0);
        System.out.println(ans);


    }
}
