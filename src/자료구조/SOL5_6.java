package 자료구조;

import java.util.*;

public class SOL5_6 {

    public int solution(String str){

        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i-1) == '(' && str.charAt(i) ==')'){
                stack.pop();
                answer+=stack.size();
            }
            else if(str.charAt(i-1) ==')' && str.charAt(i) ==')'){
                stack.pop();
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args){

        SOL5_6 T = new SOL5_6();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }

}
