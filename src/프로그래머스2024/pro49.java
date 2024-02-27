package 프로그래머스2024;

import java.util.*;

//다트 게임
public class pro49 {


    public int solution(String dartResult) {
        int answer = 0;

        String[] numtmp = dartResult.split("S|D|T|#|\\*");

        Queue<Integer> numsQ = new LinkedList<>();

        for(String s : numtmp){
            if(!s.equals("")){
                numsQ.add(Integer.parseInt(s));
            }
        }

        int n = dartResult.length();
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){

            char x = dartResult.charAt(i);

            if(x=='*'){
                if(s.size()>1){
                    Stack<Integer> list = new Stack<>();
                    list.add(s.pop()*2);
                    list.add(s.pop()*2);
                    while(!list.isEmpty()){
                        s.push(list.pop());
                    }
                }
                else{
                    s.push(s.pop()*2);
                }
                continue;
            }

            if(x=='#'){
                s.push(s.pop()*-1);
                continue;
            }
            if(x=='S' || x=='D' || x=='T'){
                int tmp = s.pop();
                int result = 0;
                switch(x){
                    case 'S' :
                        result = (int) Math.pow(tmp, 1);
                        break;
                    case 'D':
                        result = (int) Math.pow(tmp, 2);
                        break;
                    case 'T':
                        result = (int) Math.pow(tmp, 3);
                        break;
                }
                s.push(result);
            }
            else{
                if(numsQ.peek()==10){
                    i++;
                }
                s.push(numsQ.poll());
            }
        }

        while(!s.isEmpty()){
            answer+=s.pop();
        }

        return answer;
    }

    public static void main(String[] args){

        pro49 T = new pro49();

        System.out.println(T.solution("1S*2T*3S"));

    }
}
