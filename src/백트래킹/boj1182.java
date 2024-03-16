package 백트래킹;

import java.util.*;

//부분 수열의 합
public class boj1182 {

    static int[] arr;
    static int n,s;

    static int answer = 0;


    static boolean[] visited;

    public static void dfs(int depth, int sum){


        if(depth==n){
            if(sum==s){
                answer++;
            }
            return;
        }

        //원소를 선택할 때
        dfs(depth+1, sum+arr[depth]);

        //원소를 선택하지 않을 때
        dfs(depth+1, sum);

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        visited = new boolean[n];

        dfs(0,0);

        //공집합 제외
        if(s==0){
            System.out.println(answer-1);
        }
        else{
            System.out.println(answer);
        }

    }
}
