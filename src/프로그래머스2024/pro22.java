package 프로그래머스2024;

import java.util.HashMap;
import java.util.Stack;

//둘만의 암호
public class pro22 {

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> skipArr = new Stack<>();
        for(char x : skip.toCharArray()){
            skipArr.add(x);
        }

        HashMap<Character, Integer> alpha = new HashMap<>();
        int cnt = 1;
        for(int i=0; i<26; i++){
            char x = (char)(97+i);
            if(skipArr.contains(x)){
                continue;
            }
            alpha.put(x, cnt++);
        }

        for(char x : s.toCharArray()){
            int next =  alpha.get(x)+index;
            if(next>alpha.size()){
                while(next>alpha.size()){
                    next-=alpha.size();
                }
            }
            for(char c : alpha.keySet()){
                if(alpha.get(c)==next){
                    answer.append(c);
                    break;
                }
            }
        }

        return answer.toString();
    }


    public static void main(String[] args){
        pro22 T = new pro22();

        System.out.println(T.solution("z", "abcdefghij", 20));
    }
}
