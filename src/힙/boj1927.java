package 힙;

import java.util.*;

public class boj1927 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            if(x>0){
                pQ.offer(x);
            }
            else{
                if(pQ.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pQ.poll());
                }
            }
        }
    }
}
