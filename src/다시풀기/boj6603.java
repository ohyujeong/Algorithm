package 다시풀기;

import java.io.*;
import java.util.*;

public class boj6603 {

    static int[] S;
    static int k;
    static int[] answer = new int[6];
    static boolean[] visited;
    static StringBuilder sb;

    static void combi(int depth, int start){

        if(depth==6){
            sb = new StringBuilder();
            for(int i=0; i<6; i++){
                sb.append(answer[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i=start; i<k; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth]=S[i];
                combi(depth+1, i+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());


            if(k==0){
                break;
            }

            S = new int[k];
            visited = new boolean[k];

            for(int i=0; i<k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            combi(0,0);
            System.out.println();

        }
    }
}
