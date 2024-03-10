package DP;

import java.util.*;
//계단 오르기
public class boj2579 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+2];
        int[] arr = new int[n+2];

        for(int i=0; i<n; i++){

            int s = sc.nextInt();

            arr[i+1] = s;
        }

        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
        }

        System.out.println(dp[n]);
    }
}
