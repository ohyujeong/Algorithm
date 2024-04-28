package 다시풀기;

import java.util.*;
import java.io.*;

public class boj5430 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> q = new LinkedList<>();

            String nums = br.readLine();

            //[ ] <- 괄호를 떼줌
            if(!nums.equals("[]")){
                nums = nums.substring(1, nums.length()-1);

                //split 한 번만 호출 -> O(n)
                String[] numArr = nums.split(",");

                for(String s : numArr){
                    q.offer(Integer.parseInt(s));
                }
            }

            //시간 초과 코드 -> split O(n) 이 반복문 안에서 'n' 번 호출돼서 O(n^2)이 됨됨
//           for(int i=0; i<n; i++){
//                q.offer(Integer.parseInt(nums.split(",")[i]));
//            }

            //뒤집기 (R) 표시 flag = true면 반대방향
            boolean flag = false;
            boolean error = false;

            int d = 0;
            for(char x : p.toCharArray()){
                if(x=='R'){
                    flag = !flag;
                }
                //D 일 때,
                else if(x=='D' && !q.isEmpty()){
                    if(flag){
                        q.pollLast();
                    }
                    else{
                        q.pollFirst();
                    }
                }
                else if(x=='D' && q.isEmpty()){
                    System.out.println("error");
                    error = true;
                    break;
                }
            }

            if(!q.isEmpty() && !error){
                printAnswer(q, flag);
            }
            else if(!error){
                System.out.println("[]");
            }

        }
    }

    static void printAnswer(Deque<Integer> q, boolean flag){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if(flag){
            while(!q.isEmpty()){
                sb.append(q.pollLast()).append(",");
            }
        }
        else{
            while(!q.isEmpty()){
                sb.append(q.pollFirst()).append(",");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb);
    }
}
