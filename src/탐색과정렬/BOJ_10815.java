package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws IOException{

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


//        int N = Integer.parseInt(bf.readLine());

        int N = sc.nextInt();
//        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
//

        int[] card = new int[N];

        for(int i=0; i<N; i++){
//            card.add(Integer.parseInt(st.nextToken()));
            card[i] = sc.nextInt();
        }

//        Collections.sort(card);

        Arrays.sort(card);

//        int M = Integer.parseInt(bf.readLine());

        int M = sc.nextInt();
//        st = new StringTokenizer(bf.readLine(), " ");

        for(int i=0; i<M; i++){
            if(Arrays.binarySearch(card , sc.nextInt())>= 0) {
                sb.append(1).append(' ');
            }
            else {
                sb.append(0).append(' ');
            }
        }
        System.out.println(sb);
    }

//    public static int binarySearch(int key) {
//
//        int left = 0;					// 탐색 범위의 왼쪽 끝 인덱스
//        int right = card.size() - 1;	// 탐색 범위의 오른쪽 끝 인덱스
//
//        while(left <= right) {
//
//            int mid = (left + right) / 2;	// 중간위치
//
//            if(key < card.get(mid)) {
//                right = mid - 1;
//            }
//            else if(key > card.get(mid)) {
//                left = mid + 1;
//            }
//            else {
//                return mid;
//            }
//        }
//
//        // 찾고자 하는 값이 존재하지 않을 경우
//        return -1;
//
//    }



}
