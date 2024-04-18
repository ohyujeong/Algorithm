package DP;

import java.util.*;
import java.io.*;

//평범한 배낭
public class boj12865 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //dy[i]는.. i무게만큼 넣었을 때 가질 수 있는 가치의 최대값
        //최대 K만큼 무게를 넣을 수 있음
        int[] dy = new int[K+1];

        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            //K번째(최대무게)부터 현재 입력된 W무게까지 반복하면서
            for(int j=K; j>=W; j--){
                //j 무게에 원래 저장된 가치와, j-W 현재 무게의 가치를 넣었을 때 더 큰 값 선택
                dy[j] = Math.max(dy[j], dy[j-W]+V);
            }
        }

        int max = 0;
        for(int i=1; i<=K; i++){
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);



    }
}
