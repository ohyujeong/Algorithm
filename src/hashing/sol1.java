package hashing;

import java.util.*;

//인프런 it유제, 한 번 사용한 최초문자
public class sol1 {

    public int solution(String str){

        int answer = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char x:str.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x: map.keySet()){
            if(map.get(x) == 1){
                for(int i=0; i<str.length(); i++){
                    if(str.charAt(i) == x){
                        return i+1;
                    }
                }
            }
        }

        return answer;

    }

    public static void main(String[] args){
        sol1 T = new sol1();

        String s = "abcdeabcdfg";

        T.solution(s);
    }
}
