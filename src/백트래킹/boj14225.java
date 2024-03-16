package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//부분수열의 합
public class boj14225 {

    static int n;
    static int[] arr;

    static boolean[] answer;

    private static void dfs(int depth, int sum){

        if(depth==n){
            answer[sum] = true;
            return;
        }

        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = new boolean[100000*20+1];
        Arrays.sort(arr);

        dfs(0,0);

        for(int i=1; i<answer.length; i++){
            if(!answer[i]){
                System.out.println(i);
                break;
            }
        }
    }
}
