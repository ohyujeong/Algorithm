package 시뮬레이션_구현;

import java.io.*;
import java.util.*;

//AC
public class boj5430 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String nums = br.readLine();

            Deque<Integer> q = new LinkedList<>();
            if(!nums.equals("[]")){
                nums = nums.substring(1, nums.length()-1);
                String[] numArr = nums.split(",");

                for(String s : numArr){
                    q.offer(Integer.parseInt(s));
                }
            }

            //true면 뒤집은 상태.. 덱의 맨 뒤를 맨 앞으로 생각
            boolean R = false;

            int cnt = 0;

            for(char x : p.toCharArray()){
                if(x=='R'){
                    R = !R;
                }
                else if(x=='D'){
                    cnt++;
                    //버리는 횟수가 총 수의 개수n보다 크면 에러
                    if(cnt>n){
                        System.out.println("error");
                        break;
                    }
                    if(!q.isEmpty()){
                        if(R){
                            q.removeLast();
                        }
                        else{
                            q.removeFirst();
                        }
                    }
                }
            }

            if(cnt<=n){
                if(cnt==n){
                    System.out.println("[]");
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");

                    while(!q.isEmpty()){
                        if(R){
                            sb.append(q.pollLast());
                        }
                        else{
                            sb.append(q.pollFirst());
                        }
                        sb.append(",");
                    }

                    sb.deleteCharAt(sb.length()-1);
                    sb.append("]");
                    System.out.println(sb);
                }
            }

        }
    }


}
