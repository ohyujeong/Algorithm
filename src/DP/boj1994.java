package DP;

import java.util.*;
import java.io.*;

//등차 수열
public class boj1994 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println(1);
            return;
        }

        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int[][] dp = new int[N+1][N+1];


        int answer = 0;
        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                dp[i][j] = 2;
                int pre = 2*arr[i] - arr[j];
                int k =0;
                for(k=i-1; k>=1; k--){
                    if(arr[k]==pre) break;
                }
                dp[i][j] = Math.max(dp[i][j], dp[k][i]+1);
                answer = Math.max(answer,dp[i][j]);
            }
        }

        System.out.println(answer);

    }

}
