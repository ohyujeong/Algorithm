package 다시풀기;

import java.util.*;

public class boj14501 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n+1][2];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

            int next = (i+arr[i][0])-1;
            if(next<=n) dp[i]=arr[i][1];
        }

        for(int i=1; i<=n; i++){
            int next = i+arr[i][0];

            for(int j = next; j<=n; j++){
                if((j+arr[j][0])<=n+1){
                    dp[j] = Math.max(dp[j], dp[i]+arr[j][1]);
                }
            }
        }


        int answer = 0;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
