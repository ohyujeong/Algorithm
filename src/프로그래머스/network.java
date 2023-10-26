package 프로그래머스;

import java.util.*;

//네트워크
public class network {


    static boolean[] visited;
    static int answer =0;
    static Queue<Integer> q = new LinkedList<>();

    public void bfs(int node, int[][] computers, int n){
        visited[node] = true;

        q.offer(node);

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<n; i++){
                if(!visited[i] && computers[tmp][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

    }

//    public void dfs(int i, int[][] computers, int n){
//
//        visited[i] = true;
//
//        for(int j=0; j<n; j++){
//            //방문하지 않은 컴퓨터이고, 그 컴퓨터가 j번째 컴퓨터랑 연결되어 있으면
//            if(!visited[j] && computers[i][j] ==1){
//                dfs(j, computers, n);
//            }
//        }
//    }

    public int solution(int n, int[][] computers){

        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
//                dfs(i, computers, n);
                bfs(i, computers, n);
            }
        }

        return answer;
    }

}
