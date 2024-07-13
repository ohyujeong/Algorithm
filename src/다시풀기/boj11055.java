package 다시풀기;

import java.util.*;

public class boj11055 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        int[] dp = new int[N];


        for(int i=0; i<N; i++){
            dp[i] = A[i];
            for(int j=0; j<i; j++){
                if(A[j]<A[i]){
                    dp[i] = Math.max(dp[i], dp[j]+A[i]);
                }
            }
        }

        int max =0;
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
