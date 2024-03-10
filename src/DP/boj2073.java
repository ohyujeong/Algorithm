package DP;

import java.util.*;

//수도 배관 공사
public class boj2073 {

//    private static int[][] combi;
//    private static boolean[] visited;
//    private static int min = Integer.MAX_VALUE;
//    private static int answer = 0;
//
//    public static void dfs(int sum, int start, int D){
//
//        if(sum==D){
//            for(int i=0; i< visited.length; i++){
//                if(visited[i]){
//                    min=Math.min(min,combi[i][1]);
//                }
//            }
//            answer = Math.max(answer,min);
//            return;
//        }
//
//        if(start==combi.length || sum>D){
//            return;
//        }
//
//        for(int i=start; i<combi.length; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                dfs(sum+combi[i][0], i+1, D);
//                visited[i] = false;
//            }
//        }
//    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int P = sc.nextInt();

//        combi = new int[P][2];
//        visited = new boolean[P];

        int[] dp = new int[D+1];

        for(int i =0; i<P; i++){
            int L = sc.nextInt();
            int C = sc.nextInt();

            for(int j=D; j>L; j--){
                if(dp[j-L]==0) continue;
                dp[j]=Math.max(dp[j], Math.min(dp[j-L],C));
            }
            dp[L] = Math.max(dp[L],C);
        }


        System.out.println(dp[D]);
    }
}
