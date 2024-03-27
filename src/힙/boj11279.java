package 힙;

import java.util.*;
import java.io.*;
//최대 힙
public class boj11279 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                pQ.offer(x);
            }
            else if(!pQ.isEmpty()){
                System.out.println(pQ.poll());
            }
            else{
                System.out.println(0);
            }
        }

    }
}
