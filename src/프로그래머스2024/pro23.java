package 프로그래머스2024;

import java.util.*;

//신규 아이디 추천
public class pro23 {

    public String solution(String new_id) {

        String match = "[^0-9a-zA-Z-_.]";


        // 95 _
        // 46 .
        // 45 -
        //소문자로 치환
        new_id = new_id.toLowerCase();
        //특수문자 제거
        new_id = new_id.replaceAll(match,"");
        //.이 2번 이상 반복되면 . 1개로 치환
        new_id = new_id.replaceAll("\\.{2,}",".");

        List<Character> id = new ArrayList<>();

        for(char x : new_id.toCharArray()){
            id.add(x);
        }

        //4단계
        while(!id.isEmpty()){
            if(id.get(0)=='.'){
                id.remove(0);
                if(id.isEmpty()){
                    return "aaa";
                }
            }
            if(id.get(id.size()-1) == '.'){
                id.remove(id.size()-1);
            }
            else{
                break;
            }
        }


        while(id.size()>15 || id.get(id.size()-1) == '.'){
            id.remove(id.size()-1);
        }

        while(id.size()<3){
            id.add(id.get(id.size()-1));
        }

        String answer = "";
        for(char x : id){
            answer+=x;
        }
        return answer;
    }

    public static void main(String[] args){
        pro23 T = new pro23();

        String s = "=.=";
        System.out.println(T.solution(s));
    }
}
