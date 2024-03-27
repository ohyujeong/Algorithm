package 힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                else{
                    return Math.abs(o1)-Math.abs(o2);
                }
            }
        });

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
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
