package 프로그래머스2024;

import java.util.*;

//모음 사전
public class pro28 {

    public int solution(String word) {
        int answer = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A",0);
        hm.put("E",1);
        hm.put("I",2);
        hm.put("O",3);
        hm.put("U",4);

        int[] cha = {781,156,31,6,1};
        String[] wordArr = word.split("");
        answer+=wordArr.length;


        int k = 0;
        for(String s : wordArr){
            answer += cha[k++]*hm.get(s);
        }

        return answer;
    }

    public static void main(String[] args){
        pro28 T = new pro28();


        System.out.println(T.solution("AAAAE"));
        System.out.println(T.solution("AAAE"));
        System.out.println(T.solution("I"));
        System.out.println(T.solution("EIO"));
    }
}
