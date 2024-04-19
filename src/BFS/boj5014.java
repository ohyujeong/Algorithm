package BFS;

import java.util.*;
import java.io.*;

public class boj5014 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] button = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());

        //F, S, G, U, D
        for(int i=0; i<button.length; i++){
            button[i] = Integer.parseInt(st.nextToken());
        }

        //1, F층을 넘어서 갈 순 없음
        //S -> G
        //button[3] U버튼->위로 U, button[4] D버튼->아래로
        int F = button[0];
        int S = button[1];
        int G = button[2];
        int U = button[3];
        int D = button[4];

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        boolean[] visited = new boolean[F+1];

        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len;  i++){
                int cur = q.poll();
                if(cur==G){
                    System.out.println(L);
                    return;
                }
                int up = cur+U;
                int down = cur-D;
                if(!visited[up] && up<=F){
                    visited[up] = true;
                    q.offer(up);
                }
                if(!visited[down] && down>=1){
                    visited[down] = true;
                    q.offer(down);
                }
            }
            L++;
        }

        System.out.println("use the stairs");
    }
}
