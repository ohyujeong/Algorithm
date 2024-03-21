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

        int[][] arr = new int[2][n+1];
        int[] dy = new int[n+1];

        StringTokenizer st;
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            int next = i+arr[0][i];
            if(next-1<=n){
                dy[i] = arr[1][i];
            }
        }

        for(int i=1; i<=n; i++){
            //i번째 상담을 할 때, i번째 상담 소요시간(arr[0][i]) 끝난 후 가능한 바로 다음 상담
           int next = i+arr[0][i];
           //그 다음으로 가능한 상담 번호부터 순회하며 최댓값 찾음
            for(int j=next; j<=n; j++){
                //j번째 상담의 소요시간이 퇴사날짜를 넘지 않을 때
                if((j+arr[0][j])-1<=n){
                    dy[j] = Math.max(dy[j], dy[i]+arr[1][j]);
                }
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);

    }
}
