package DP;

import java.util.*;
import java.io.*;

//상자 넣기
public class boj1965 {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=1; j<=i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max =0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
