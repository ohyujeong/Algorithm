package DP;

import java.util.*;
//사탕가게
public class boj4781 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            int n = sc.nextInt();
            int m = (int)Math.round(sc.nextDouble()*100);

            if(n==0 && m==0){
                break;
            }

            //돈의 크기만큼 배열을 만들어줌
            int[] dp = new int[m+1];
            for(int i=0; i<n; i++){
                int c = sc.nextInt();
                int p = (int)Math.round(sc.nextDouble()*100);
                for(int j=p; j<=m; j++){
                    dp[j] = Math.max(dp[j], dp[j-p]+c);
                }
            }
            int answer = dp[m];
            System.out.println(answer);
        }
    }
}
