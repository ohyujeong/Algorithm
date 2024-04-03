package greedy;

import java.util.*;
import java.io.*;

public class boj1931 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pQ.offer(new int[]{start,end});
        }

        int[] prev = pQ.poll();
        int ans = 1;

        while(!pQ.isEmpty()){
            int[] cur = pQ.poll();
            if(cur[0]>=prev[1]){
                ans++;
                prev = cur;
            }
        }

        System.out.println(ans);

    }

}
