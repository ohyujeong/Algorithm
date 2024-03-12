package DP;

import java.util.*;

//평범한 배낭
public class boj12865 {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[K+1];

        for(int i=0; i<N; i++){
            int W = sc.nextInt();
            int V = sc.nextInt();

            for(int j=K; j>=W; j--){
                dp[j] = Math.max(dp[j], dp[j-W]+V);
            }
        }

        System.out.println(dp[K]);
    }
}
