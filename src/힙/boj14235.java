package 힙;

import javax.crypto.Cipher;
import java.util.*;
import java.io.*;

//크리스마스 선물
public class boj14235 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        while(n-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==0){
                if(pQ.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(pQ.poll());
                }
                continue;
            }

            for(int i=0; i<a; i++){
                int num = Integer.parseInt(st.nextToken());
                pQ.offer(num);
            }

        }

    }
}
