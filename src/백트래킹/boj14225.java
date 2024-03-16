package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//부분수열의 합
public class boj14225 {

    static int n;
    static int[] arr;

    static boolean[] answer;
    static boolean[] visited;

    private static void dfs(int target, int sum, int start){

        answer[sum] = true;

        if(target==sum){
            answer[target] = true;
            return;
        }


        for(int i=start; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(target, sum+arr[i], i+1);
                if(answer[target]) break;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        answer = new boolean[2000001];

        Arrays.sort(arr);

        int num=1;
        while(true){
            visited = new boolean[n];
            dfs(1,0,0);
            if(!answer[num]){
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
