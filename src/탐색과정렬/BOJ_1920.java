package 탐색과정렬;

import java.util.*;

public class BOJ_1920 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];


        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 탐색 위해서 배열 정렬
        Arrays.sort(A);

        int M = sc.nextInt();
        int[] B = new int[M];


        for(int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        for(int i = 0; i < M; i++) {

            // return값이 -1이 아니면 찾는 값이 있는 경우, return 값 -1이면 없는 경우
            if(binarySearch(A, B[i]) >= 0) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    public static int binarySearch(int[] arr, int key) {

        int left = 0;					// 탐색 범위의 왼쪽 끝 인덱스
        int right = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스

        while(left <= right) {

            int mid = (left + right) / 2;	// 중간위치

            if(key < arr[mid]) {
                right = mid - 1;
            }
            else if(key > arr[mid]) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;

    }
}
