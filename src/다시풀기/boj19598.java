package 다시풀기;

import java.util.*;

class Meet{
    int start;
    int end;
    public Meet(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class boj19598 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Meet> pQ = new PriorityQueue<>(new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }
                return o1.start-o2.start;
            }
        });

        for(int i=0; i<N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            pQ.offer(new Meet(start,end));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();

        //첫 번째로 시작 하는 회의의 끝나는 시간
        room.add(pQ.poll().end);

        while(!pQ.isEmpty()){
            Meet nextMeet = pQ.poll();
            int nextStart = nextMeet.start;

            //회의실의 가장 앞(가장 빨리 끝나는 회의) 가 nextStart보다 크면 새로운 회의실 열어야 함
            //회의실의 가장 빨리 끝나는 회의가 nextStart와 시간이 같거나, 작으면 해당 회의실에서 다음 회의 진행
            if(room.peek()<=nextStart){
                room.poll();
            }
            room.add(nextMeet.end);
        }

        System.out.println(room.size());

    }
}
