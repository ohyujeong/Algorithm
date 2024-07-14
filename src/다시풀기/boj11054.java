package 다시풀기;

import java.util.*;

public class boj11054 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[] topDp = new int[N];
        int[] downDp = new int[N];

        //오름차순 수열 개수
        for(int i=0; i<N; i++){
            topDp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    topDp[i] = Math.max(topDp[i], topDp[j]+1);
                }
            }
        }

        //내림차순 수열 개수
        for(int i=N-1; i>=0; i--){
            downDp[i] = 1;
            for(int j=N-1; j>i; j--){
                if(arr[j]<arr[i]){
                    downDp[i] = Math.max(downDp[i], downDp[j]+1);
                }
            }
        }

        int[] result = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            result[i] = topDp[i]+downDp[i];
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer-1);
    }
}
