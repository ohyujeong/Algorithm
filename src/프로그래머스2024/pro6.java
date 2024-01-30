package 프로그래머스2024;

import java.util.HashMap;

//성격 유형 검사하기
public class pro6 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<Character, Integer> hm = new HashMap<>();

        char[] arr = {'R','T','C','F','J','M','A','N'};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        for(char x : arr){
            hm.put(x, 0);
        }

        for(int i=0; i<choices.length; i++){
            char x1 = survey[i].charAt(0);
            char x2 = survey[i].charAt(1);
            int choice = choices[i];
            if(choices[i]<4){
                hm.put(x1, hm.get(x1)+score[choice]);
            }
            if(choices[i]>4){
                hm.put(x2, hm.get(x2)+score[choice]);
            }
        }

        for(int i=0; i<7; i+=2){
            char x1 = arr[i];
            char x2 = arr[i+1];
            if(hm.get(x1)>=hm.get(x2)){
                answer+=x1;
            }
            else{
                answer+=x2;
            }
        }

        return answer;
    }


    public static void main(String[] args){
        pro6 T = new pro6();


        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        T.solution(survey, choices);
    }
}
