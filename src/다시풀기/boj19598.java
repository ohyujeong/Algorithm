package 다시풀기;

import java.io.*;
import java.util.*;

public class boj19598 {

    static class Meet{
        int start;
        int end;
        public Meet(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //시작 시간이 빠른 순으로 내림차순 정렬
        PriorityQueue<Meet> q = new PriorityQueue<>(new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }
                return o1.start-o2.start;
            }
        });

        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.offer(new Meet(start,end));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(q.poll().end);

        while(!q.isEmpty()){
            int prev = room.peek();
            Meet next = q.poll();
            //다음 회의 시작 시간이 이전회의의 끝나는 시간보다 이후면 같은 회의실에서 할 수 있음
            if(next.start >= prev){
                //기존회의는 회의실 나가줌
                room.poll();
            }
            //시작시간이 끝나는 시간보다 이전이면 기존회의는 회의실 안 나가고
            //다음 회의는 다른 회의실에서 회의 시작
            room.add(next.end);
        }

        int answer = 0;
        answer = room.size();
        System.out.println(answer);
    }
}
