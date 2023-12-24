package greedy;

import java.util.*;

//택배 배달과 수거하기
public class kakao2023 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;

        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];

            while(d<0 || p <0){
                d+=cap;
                p+=cap;
                answer+=(i+1)*2;
            }
        }

        return answer;
    }

    public static void main(String[] args){

        kakao2023 T = new kakao2023();

        int cap = 4;
        int n = 5;
        int[] arr1 = {1,0,3,1,2};
        int[] arr2 = {0,3,0,4,0};

        T.solution(cap, n, arr1, arr2);
    }
}
