package BFS;

import java.util.*;
import java.io.*;

public class boj5014 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1, F층을 넘어서 갈 순 없음
        //S -> G
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int[] dir = new int[2];
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -(Integer.parseInt(st.nextToken()));

        int[] visited = new int[F+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        //방문
        visited[S] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==G){
                System.out.println(visited[G]-1);
                return;
            }
            for(int j=0; j<2; j++){
                int next = cur+dir[j];
                if(next>F || next<1){
                    continue;
                }
                if(visited[next]==0){
                    visited[next] = visited[cur]+1;
                    q.offer(next);
                }
            }
        }

        System.out.println("use the stairs");
    }
}
