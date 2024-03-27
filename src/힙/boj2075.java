package 힙;

import java.io.*;
import java.util.*;

public class boj2075 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                if (pQ.size() < n || num > pQ.peek()) {
                    if (pQ.size() == n) pQ.poll();
                    pQ.offer(num);
                }
            }
        }

        System.out.println(pQ.poll());

    }
}

