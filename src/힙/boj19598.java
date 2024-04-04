package 힙;

import java.util.*;
import java.io.*;


//최소 회의실 개수
public class boj19598 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pQ.offer(new int[]{start,end});
        }


        //진행되고 있는 회의들
        PriorityQueue<Integer> room = new PriorityQueue<>();

        //현재 진행중인 회의가 끝나는 시간
        room.add(pQ.poll()[1]);

        while(!pQ.isEmpty()){
            int prev = room.peek();
            int next[] = pQ.poll();
            //다음 회의 시작시간이 이전회의의 끝나는 시간보다 이후면 같은 회의실에서 할 수 있음
            if(next[0] >= prev){
                //기존회의는 회의실 나가줌
                room.poll();
            }
            //시작시간이 끝나는 시간보다 이전이면 기존회의는 회의실 안 나가고
            //다음 회의는 다른 회의실에서 회의 시작
            room.add(next[1]);
        }

        int ans = 0;
        ans = room.size();

        System.out.println(ans);
    }

}
