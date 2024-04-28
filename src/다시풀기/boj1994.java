package 다시풀기;

import java.util.*;
import java.io.*;

public class boj1994 {

    static int N;
    static int[] arr;
    static int answer = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println(1);
            return;
        }

        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        HashMap<Integer, Integer>[] dp = new HashMap[N];

        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = arr[j] - arr[i];
                int len = dp[i].getOrDefault(diff, 1) + 1;
                dp[j].put(diff, Math.max(dp[j].getOrDefault(diff, 1), len));
                answer = Math.max(answer, len);
            }
        }

        System.out.println(answer);
    }
}
