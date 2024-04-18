package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퇴사
public class boj14501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][2];
        int[] dp = new int[n+1];

        StringTokenizer st;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            int next = (i+arr[i][0])-1;
            if(next<=n) dp[i]=arr[i][1];
        }

        for(int i=1; i<=n; i++){

            //i번째 상담했을 때, 다음으로 수행할 수 있는 날짜
            int next = i+arr[i][0];

            for(int j=next; j<=n; j++){
                //j번째 상담 할 때, 퇴사 전에 끝날 수 있을 때
                if((j+arr[j][0])<=n+1){
                    //j번째 상담의 최대이익
                    dp[j] = Math.max(dp[j], dp[i]+arr[j][1]);
                }

            }

        }


        int max  = 0;
        for(int i=1; i<=n; i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
