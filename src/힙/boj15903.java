package 힙;

import java.util.*;
import java.io.*;
//카드 합체 놀이
public class boj15903 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pQ = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            long num = Long.parseLong(st.nextToken());
            pQ.offer(num);
        }

        for(int i=0; i<m; i++){
            long sum = pQ.poll() + pQ.poll();
            pQ.offer(sum);
            pQ.offer(sum);
        }

        long ans = 0;

        while(!pQ.isEmpty()){
            ans +=pQ.poll();
        }

        System.out.println(ans);
    }
}
