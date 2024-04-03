package 힙;

import java.util.*;
import java.io.*;

public class boj23757 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pQ.offer(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            int cnt = pQ.poll();
            if(cnt>=arr[i]){
                cnt-=arr[i];
                if(cnt>0){
                    pQ.offer(cnt);
                }
            }
            else{
                flag = false;
            }
        }

        if(flag){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
