package 프로그래머스2024;

import java.util.*;

//모의고사 - 완전탐색
public class pro25 {
    public int[] solution(int[] answers) {

        int[] score = new int[3];

        int[] a = {1, 2, 3, 4, 5}; //5
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        for(int i=0; i<answers.length; i++){
            if(answers[i] == a[i%a.length]) score[0]++;
            if(answers[i] == b[i%b.length]) score[1]++;
            if(answers[i] == c[i%c.length]) score[2]++;
        }

        int max = Math.max(score[0],Math.max(score[1],score[2]));

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(score[i]==max){
                result.add(i+1);
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        pro25 T = new pro25();

        System.out.println(Arrays.toString(T.solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1,3,2,4,2})));
    }
}
