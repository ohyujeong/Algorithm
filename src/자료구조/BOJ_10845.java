package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        int last = 0;

        for(int i=0; i<N; i++){

            String cons = br.readLine();

            if(cons.contains("push")){
                String[] spt = cons.split(" ");
                last = Integer.parseInt(spt[1]);
                que.offer(last);
            }
            else if(cons.contains("pop")){
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            }
            else if(cons.contains("size")){
                sb.append(que.size()).append('\n');
            }
            else if(cons.contains("empty")){
                if(que.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(cons.contains("front")){
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(que.peek()).append('\n');
                }
            }
            else if(cons.contains("back")){
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(last).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

}
