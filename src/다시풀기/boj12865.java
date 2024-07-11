package 다시풀기;

import java.util.*;
import java.io.*;

public class boj12865 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //물품의 수
        int N = Integer.parseInt(st.nextToken());
        //버틸 수 있는 무게
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            //무게 (W)
            arr[i][0] = Integer.parseInt(st.nextToken());
             //가치 (V)
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        //버틸 수 있는 무게 만큼 dp 배열 만들기 무게가 1일 때 최대가치... 무대가 K일 때 최대가치
        int[] dp = new int[K+1];

        //물건 개수대로 차례대로 물건을 꺼내오면서 dp에 누적..
        for(int i=0; i<N; i++){
            int W = arr[i][0];
            int V = arr[i][1];

            //W무게를 넣을 때의 가치와 안 넣었을 때의 가치값 비교
            //W까지 순회하면서 최대값을 저장함.
            for(int j=K; j>=W; j--){
                dp[j] = Math.max(dp[j], dp[j-W]+V);
            }

        }



        System.out.println(dp[K]);

    }


}
