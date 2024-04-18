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

        //dp[i] = i번째 상자를 포함할 때 최대횟수
        for(int i=1; i<=n; i++){
            //처음엔 자기자신을 무조건 포함하니까 1로 초기화
            dp[i]=1;
            //상자의 처음부터 자기자신(i)까지 오면서
            for(int j=1; j<=i; j++){
                //앞 상자(j번째)가 자신(i) 보다 크기가 작으면 넣을 수 있음
                if(arr[j]<arr[i]){
                    //dp[j]도 1부터 j까지 넣을 수 있는 상자의 최대값이 저장되어 있음
                    //안 넣는게 최대값(dp[i]) 인지 넣는게 dp[j]+1 최대값인지..
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max =0;
        for(int i : dp){
            max = Math.max(i, max);
        }

        System.out.println(max);
    }
}
