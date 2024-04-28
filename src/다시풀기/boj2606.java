package 다시풀기;

import java.util.*;
import java.io.*;

public class boj2606 {

    static int N,connect;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        connect = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<connect; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        answer = 0;
        visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int start = q.poll();
            for(int i=0; i<graph.get(start).size(); i++){
                int next = graph.get(start).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }


}
