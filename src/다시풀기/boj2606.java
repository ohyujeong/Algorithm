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

        visited = new boolean[N+1];
        dfs(1);
        //시작 컴퓨터 빼줌
        System.out.println(answer-1);

    }

    static void dfs(int idx){

        visited[idx] = true;
        answer++;

        for(int i=1; i<=N; i++){
            if(!visited[i] &&graph.get(idx).contains(i)){
                dfs(i);
            }
        }
    }


}
