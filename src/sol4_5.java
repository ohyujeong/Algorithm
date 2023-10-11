import java.util.*;


public class sol4_5 {


    public int solution(int[] arr, int n, int k){

        int answer = -1;

        //내림차순 정렬
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            //중복 방지를 위해 +1해서 for 문 돎
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int cnt =0;
        for(int x: Tset){
            cnt++;
            if(cnt == k){
                return x;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        sol4_5 T = new sol4_5();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr,N, K));
    }

}
