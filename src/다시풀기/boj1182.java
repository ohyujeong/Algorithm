package 다시풀기;

import java.util.*;
import java.io.*;

public class boj1182 {

    static int N,S;
    static int answer = 0;
    static boolean[] visited;
    static int[] arr;

    static void combi(int depth, int start, int sum){

        if(depth>0 && sum==S){
            answer++;
        }

        if(depth==N){
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(depth+1, i+1, sum+arr[i]);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0,0,0);
        System.out.println(answer);

    }
}
