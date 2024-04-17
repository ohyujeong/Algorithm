package DP;

import java.util.*;

public class boj14916 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+10];

        if(n==1 || n==3){
            System.out.println(-1);
            return;
        }

        dp[2]=1;
        dp[4]=2;
        dp[5]=1;

        for(int i=6; i<=n; i++){
            if(i%5==0){
                dp[i]=(i/5);
            }
            else{
                dp[i]=dp[i-2]+dp[2];
            }
        }

        System.out.println(dp[n]);

    }
}
