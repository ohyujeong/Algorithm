package 힙;

import java.util.*;
import java.io.*;

//최소 회의실 개수
public class boj19598 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Time> pQ = new PriorityQueue<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pQ.add(new Time(Integer.parseInt(st.nextToken()), true)); // 시작시간
            pQ.add(new Time(Integer.parseInt(st.nextToken()), false)); // 종료시간
        }


        int cnt = 0; //회의실 개수
        int ans = 0; //최대값

        while(!pQ.isEmpty()){
            Time t = pQ.poll();
            if(t.isStart){
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else{
                cnt--;
            }
        }

        System.out.println(ans);
    }

    static class Time implements Comparable<Time>{
        int time;
        boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }
}
