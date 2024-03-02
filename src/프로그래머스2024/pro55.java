package 프로그래머스2024;

import java.util.*;

//외톨이 알파벳
public class pro55 {

    public String solution(String input_string) {
        String answer = "";

        //외톨이 판별 맵
        Map<Character,Boolean> map = new HashMap<>();
        //중복 판별
        Set<Character> set = new TreeSet<>();

        char current=' ';

        for(char tmp: input_string.toCharArray()){
            if(current!=tmp){
                if(map.containsKey(tmp)){
                    set.add(tmp);
                }
                map.put(tmp,true);
                current=tmp;
            }
        }

        for(char temp :set){
            answer+=temp;
        }

        if(answer==""){
            return "N";
        }

        return answer;
    }

    public static void main(String[] args){

        pro55 T = new pro55();

        System.out.println(T.solution("edeaaabbccd"));
        System.out.println(T.solution("eeddee"));
        System.out.println(T.solution("string"));
        System.out.println(T.solution("zbzbz"));
    }
}
