package DP;

import java.io.*;

//동물원
public class boj1309 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        //dp[i][j] = n // i번쨰 줄에서 j번째 칸에 동물을 놓을 수 있는 경우의 수가 n
        //j가 0이면 동물 안 넣음, 1이면 왼쪽칸 2면 오른쪽 칸
        int[][] dp = new int[n + 1][3];

        //n이 1일 땐 한가지의 경우만 가능
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }


        System.out.print((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}
