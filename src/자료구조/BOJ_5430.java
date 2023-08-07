package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while( T --> 0 ){
            String com = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<Integer>();

            for(int i=0; i<n; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(com,deque);

        }

        System.out.println(sb);

    }

    public static void AC(String com, ArrayDeque<Integer> deque){
        boolean isRight = true;

        for(char cmd : com.toCharArray()){

            if(cmd == 'R'){
                isRight = !isRight; // false라고 안 하는 이유.. 다시 R하면 true로 바꿔줘야하니까
                continue;
            }
            if(isRight){
                if(deque.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            }
            else{
                if(deque.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, isRight);
    }

    private static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');

        if(deque.size() > 0 ){
            if(isRight){
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());

                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');

    }
}
