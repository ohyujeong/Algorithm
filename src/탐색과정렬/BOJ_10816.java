package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] card = new int[N];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(card, key) - lowerBound(card, key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때까지 반복
        while(lo < hi){

            int mid = (lo + hi) / 2;

            if(key <= arr[mid]){
                hi = mid;
            }
            else{
                lo = mid +1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while( lo < hi){
            int mid = (lo+hi)/2;

            if(key < arr[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
         return lo;
    }

}
