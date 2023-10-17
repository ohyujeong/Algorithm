package DFS;

import java.util.Scanner;

public class SOL8_2 {

    static int C,N;
    static int answer = Integer.MIN_VALUE;

    public void dfs(int L, int sum, int[] arr){

        if(sum>C){
            return;
        }
        if(L==N){
            answer = Math.max(answer, sum);
//            if(sum>answer){
//                answer = sum;
//            }
        }
        else{
            dfs(L+1, sum+arr[L], arr);
            dfs(L+1, sum, arr);
        }
    }

    public static void main(String[] args){

        SOL8_2 T = new SOL8_2();

        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        T.dfs(0,0, arr);
        System.out.println(answer);

    }
}
