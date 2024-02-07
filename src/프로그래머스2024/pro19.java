package 프로그래머스2024;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//덧칠하기
public class pro19 {

    public int solution(int n, int m, int[] section) {

        int answer = 1;
        int start = section[0];

        for (int i : section) {
            if (start + m > i) {
                continue;
            }
            start = i;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){

        pro19 T = new pro19();

        T.solution(8,4, new int[]{2,3,6});
        T.solution(5,4, new int[]{1,3});
        T.solution(4,1, new int[]{1,2,3,4});
    }
}
