package DP;

import java.util.*;
import java.io.*;

//가장 긴 바이토닉 부분 수열
public class boj11054 {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int[] dpLR = new int[n];
        for (int i = 0; i < n; i++) {
            dpLR[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpLR[i] = Math.max(dpLR[j] + 1, dpLR[i]);
                }
            }
        }

        // 오른쪽에서 왼쪽으로 LIS 구하기
        int[] dpRL = new int[n];
        for (int i = n-1; i >=0; i--) {
            dpRL[i] = 1;
            for (int j = n-1; j >=i; j--) {
                if (arr[i] > arr[j]) {
                    dpRL[i] = Math.max(dpRL[j] + 1, dpRL[i]);
                }
            }
        }

        // 두 dp 배열의 합의 최대값 찾기
        int max = 0;
        for (int i = 0; i <n; i++) {
            max = Math.max(max, dpLR[i] + dpRL[i]);
        }

        System.out.println(max-1);
    }
}
