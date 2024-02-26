package 프로그래머스2024;

import java.util.*;

//최솟값 만들기
public class pro47 {

    public int solution(int []A, int []B) {

//낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> LowestA = new PriorityQueue<>();

//높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> HighestB = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : A){
            LowestA.add(i);
        }

        for(int i : B){
            HighestB.add(i);
        }

        int answer = 0;

        while(!LowestA.isEmpty()){
            answer += LowestA.poll()*HighestB.poll();
        }

        return answer;
    }

    public static void main(String[] args){

        pro47 T = new pro47();

        int[] A = {1,2};
        int[] B = {3,4};
        T.solution(A,B);

    }
}
