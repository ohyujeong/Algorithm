package 프로그래머스2024;

import java.util.*;

//숫자 짝꿍
public class pro41 {

    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(char x : X.toCharArray()){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }

        //공통 정수 리스트
        ArrayList<Character>list = new ArrayList<>();

        for(char x : Y.toCharArray()){
            if(hm.containsKey(x) && hm.get(x)>0){
                list.add(x);
                hm.put(x, hm.get(x)-1);
            }
        }

        if(list.size()==0){
            return "-1";
        }

        Collections.sort(list, Collections.reverseOrder());
        if(list.get(0)=='0'){
            return "0";
        }
        for(char x : list){
            answer.append(x);
        }

        return answer.toString();
    }

    public static void main(String[] args){

        pro41 T = new pro41();
//
//        T.solution("100", "2345");
        T.solution("5525", "1255");
    }
}
