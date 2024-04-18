package DP;

import java.util.*;
import java.io.*;

//RGB 거리
public class boj1149 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        //dp[i][0] == i번째 집에 0번째 색을 칠할 때 최소 비용
        //0번째 색을 칠할 땐, 윗집이 1번째거나, 2번째 색인 경우만 가능
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
        }

        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));

    }
}
