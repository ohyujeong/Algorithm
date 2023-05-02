package 탐색과정렬;

import java.util.*;

public class BOJ_2750 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
