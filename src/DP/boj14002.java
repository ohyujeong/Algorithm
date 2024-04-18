package DP;

import java.util.*;
import java.io.*;

//가장 긴 증가하는 부분수열4(LIS)
public class boj14002 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i] == i번째 인덱스에서 끝나는 부분수열의 최대길이
        int[] dp = new int[A];

        for(int i=0; i<A; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max= 0;
        for(int i=0; i<A; i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max+"\n");

        Stack<Integer> s = new Stack<>();
        for(int i=A-1; i>=0; i--){
            if(dp[i] == max){
                s.push(arr[i]);
                max--;
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb);

    }
}
