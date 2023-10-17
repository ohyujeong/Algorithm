package DFS;

import java.util.Scanner;

public class SOL8_1 {

    static int N,total;
    static boolean flag = false;
    static String answer ="NO";

    public void dfs(int L, int sum, int[] arr){
        if(flag){
           return;
        }
        if(L==N){
            if((total-sum) == sum){
                answer = "YES";
                flag =true;
            }
        }
        else{
            dfs(L+1, sum+arr[L], arr);
            dfs(L+1, sum, arr);

        }
    }

    public static void main(String[] args){

        SOL8_1 T = new SOL8_1();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[]arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            total+=arr[i];
        }

        T.dfs(0,0,arr);
        System.out.println(answer);
    }
}
