package 프로그래머스2024;

import java.util.*;
//문자열 나누기
public class pro42 {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();


        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(st.size()==0 || st.peek()==x){
                st.push(x);
            }
            else{
                st2.push(x);
            }
            if(st.size()==st2.size()){
                answer++;
                st.clear();
                st2.clear();
            }
        }

        if(st.size()>0 || st2.size()>0){
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        pro42 T = new pro42();

        T.solution("aaabbaccccabba");
    }
}
