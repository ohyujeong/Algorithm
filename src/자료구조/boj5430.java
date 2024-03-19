package 자료구조;

import java.util.*;
import java.io.*;

public class boj5430 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(t-->0){

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> q = new ArrayDeque<>();

            for(int i=0; i<n; i++){
                q.offer(Integer.parseInt(st.nextToken()));
            }

            boolean flag = false;
            boolean print = false;

            for(char x : p.toCharArray()){
                if(x=='R'){
                    if(!flag){
                        flag = true;
                    }
                    else if(flag){
                        flag = false;
                    }
                }
                else if(x=='D' && !q.isEmpty()){
                    if(flag){
                        q.pollLast();
                    }
                    else{
                        q.poll();
                    }
                }
                else{
                    System.out.println("error");
                    print = true;
                    break;
                }
            }

            if(!print){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!q.isEmpty()){
                    if(!flag){
                        sb.append(q.poll());
                    }
                    else{
                        sb.append(q.pollLast());
                    }
                    sb.append(",");
                }
                if(sb.charAt(sb.length()-1)==','){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
