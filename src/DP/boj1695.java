package DP;

import java.util.*;
import java.io.*;

//팰린드롬 만들기
public class boj1695 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dy = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){

                if(arr[j] == arr[j+i]) dy[j][j+i] = dy[j+1][j+i-1];
                else{
                    dy[j][j+i] = Math.min(dy[j+1][j+i], dy[j][j+i-1])+1;
                }
            }
        }


        System.out.println(dy[1][n]);

    }
}
