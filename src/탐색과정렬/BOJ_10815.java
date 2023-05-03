package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10815 {

    public static ArrayList<Integer> card = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");


        for(int i=0; i<N; i++){
            card.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(card);

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine(), " ");

        for(int i=0; i<M; i++){
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append(' ');
            }
            else {
                sb.append(0).append(' ');
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int key) {

        int left = 0;					// 탐색 범위의 왼쪽 끝 인덱스
        int right = card.size() - 1;	// 탐색 범위의 오른쪽 끝 인덱스

        while(left <= right) {

            int mid = (left + right) / 2;	// 중간위치

            if(key < card.get(mid)) {
                right = mid - 1;
            }
            else if(key > card.get(mid)) {
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
