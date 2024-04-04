package 프로그래머스2024;

import java.util.*;
//더 맵게
public class pro67 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i : scoville){
            pQ.offer(i);
        }


        if(pQ.peek()==K){
            return 0;
        }

        while(pQ.size()>=2){
            int low1 = pQ.poll();
            int low2 = pQ.poll()*2;
            pQ.offer(low1+low2);
            answer++;
            if(pQ.peek()>=K){
                break;
            }
        }

        if(pQ.peek()<K){
            return -1;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        pro67 T = new pro67();

        T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }
}
