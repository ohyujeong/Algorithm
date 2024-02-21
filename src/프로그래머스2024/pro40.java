package 프로그래머스2024;

import java.util.*;

//연속 부분 수열 합의 개수
public class pro40 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i=1; i<=elements.length; i++) {
            for (int j=0; j<elements.length; j++) {
                int sum = 0;
                for (int k=j; k<j+i; k++) {
                    sum += elements[k%elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }


    public static void main(String[] args){
        pro40 T = new pro40();

        System.out.println(T.solution(new int[]{7,9,1,1,4}));
    }
}
