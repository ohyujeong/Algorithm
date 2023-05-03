package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            String cons = br.readLine();

            if(cons.contains("push")){
                String[] spt = cons.split(" ");
                stack.push(Integer.parseInt(spt[1]));
            }
            else if(cons.contains("pop")){
                if(stack.empty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stack.pop()).append('\n');
                }
            }
            else if(cons.contains("size")){
                sb.append(stack.size()).append('\n');
            }
            else if(cons.contains("empty")){
                if(stack.empty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append('\n');
                }
            }
            else if(cons.contains("top")){
                if(stack.empty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stack.peek()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }

}
