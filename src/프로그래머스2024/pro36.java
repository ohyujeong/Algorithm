package 프로그래머스2024;

import java.util.*;
//가장 가까운 글자
public class pro36 {

    public int[] solution(String s) {

        int[] answer = new int[s.length()];

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            answer[i] = i-hm.getOrDefault(s.charAt(i),i+1);
            hm.put(s.charAt(i), i);
//            if(!hm.containsKey(s.charAt(i))){
//                answer[i] = -1;
//                hm.put(s.charAt(i), i);
//            }
//            if(answer[i]==0){
//                answer[i] = i-hm.get(s.charAt(i));
//            }
//            hm.put(s.charAt(i), i);
        }


        return answer;
    }

    public static void main(String[] args){

        pro36 T = new pro36();

        T.solution("banana");
        T.solution("foobar");
    }
}
