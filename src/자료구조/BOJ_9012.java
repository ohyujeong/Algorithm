package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++){
            sb.append(solve(bf.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String solve(String s){
        Stack<Character> stack = new Stack<>();

        for (int i=0; i< s.length(); i++){

            char c = s.charAt(i);

            if(c == '('){
                stack.push(c);
            }

            else if (stack.empty()){
                return "NO";
            }

            else{
                stack.pop();
            }
        }
        if(stack.empty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
