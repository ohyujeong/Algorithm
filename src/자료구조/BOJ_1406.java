package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            leftStack.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for(int i =0; i<M; i++){

            String cons = br.readLine();

            switch (cons.charAt(0)) {
                case 'P' : {
                    leftStack.push(cons.charAt(2));
                    break;
                }
                case 'L' : {
                    if(leftStack.isEmpty()){
                        continue;
                    }
                    rightStack.push(leftStack.pop());
                    break;
                }
                case 'D' : {
                    if(rightStack.isEmpty()){
                        continue;
                    }
                    leftStack.push(rightStack.pop());
                    break;
                }
                case'B' : {
                    if(leftStack.isEmpty()){
                        continue;
                    }
                    leftStack.pop();
                    break;
                }
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}
