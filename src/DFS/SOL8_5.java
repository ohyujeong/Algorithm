package DFS;

import java.util.*;

public class SOL8_5 {

    static int N,M;
    static int answer = Integer.MAX_VALUE;

    public void dfs(int L, int sum, Integer[] arr){
        if(sum>M){
            return;
        }
        if(sum==M){
            answer = Math.min(answer, L);
        }
        if(L>=answer){
            return;
        }
        else {
            for(int i=0; i<N; i++){
                dfs(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args){

        SOL8_5 T = new SOL8_5();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        //Collection 쓰기 위해서 int 말고 객체형 Integer로 선언
        Integer[] arr = new Integer[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        //시간초과 때문에 내림차순으로 정렬해서 금액이 큰 동전부터 봄
        //최소로 사용할 수 있는 동전 개수를 보는거니까..
        Arrays.sort(arr, Collections.reverseOrder());
        M = sc.nextInt();

        T.dfs(0,0, arr);
        System.out.println(answer);
    }
}
