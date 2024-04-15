package DP;

import java.io.*;

public class boj9095 {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        while(T-->0){

            int n = Integer.parseInt(br.readLine());

            dp[1]=1;
            dp[2]=2;
            dp[3]=4;

            for(int i=4; i<=n; i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }

            System.out.println(dp[n]);
        }

    }
}
