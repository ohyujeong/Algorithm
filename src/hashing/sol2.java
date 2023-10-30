package hashing;

import java.util.*;
//인프런 it유제, 같은 빈도수 만들기
public class sol2 {

    static int max = 0;

    public int[] solution(String str){
        int[] answer = new int[5];

        HashMap<Character, Integer> map = new HashMap<>();

        for(char x:str.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        Integer max = Collections.max(map.values());

        String alpha = "abcde";
        for(int i=0; i<answer.length; i++){
            answer[i] = max-map.getOrDefault(alpha.charAt(i),0);
//            if(map.containsKey(alpha.charAt(i))){
//                answer[i] = max-(map.get(alpha.charAt(i)));
//            }
//            else{
//                answer[i] = max;
//            }
        }

        return answer;
    }

    public static void main(String[] args){

        sol2 T = new sol2();

        String str = "aaabc";
        T.solution(str);

        String str2 = "abcdeabc";
        T.solution(str2);
    }
}
