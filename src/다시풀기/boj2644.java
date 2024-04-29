package 다시풀기;

import java.util.*;
import java.io.*;

public class boj2644 {

    static int n,m;
    static int p1,p2;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

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

        Queue<Integer> q = new LinkedList<>();

        q.offer(p1);
        visited[p1] = true;

        int L = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int cur = q.poll();
                for(int j=0; j<graph[cur].size(); j++){
                    int next = graph[cur].get(j);
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            L++;
            if(q.contains(p2)){
                break;
            }
        }

        if(visited[p2]){
            System.out.println(L);
        }
        else{
            System.out.println(-1);
        }

    }
}
