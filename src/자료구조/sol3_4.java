package 자료구조;

import java.util.*;

//피부과
public class sol3_4 {

    public int solution(int[] laser, String[] enter){
        int answer = 0;

        Queue<int[]> q = new LinkedList<>();

        int startNum = Integer.parseInt(enter[0].split(" ")[1]);
        int startTime = getTime(enter[0].split(" ")[0]);
        int endTime = startTime+laser[startNum];

        for(int i=1; i<enter.length; i++){

            int laserNum = Integer.parseInt(enter[i].split(" ")[1]);
            int arrival = getTime(enter[i].split(" ")[0]);

            if(arrival<endTime){
                q.offer(new int[]{i, laserNum});
            }
            else{
                answer = Math.max(answer, q.size());
                while(endTime<arrival && !q.isEmpty()){
                    int[] next = q.poll();
                    endTime+=laser[next[1]];
                }
                if(arrival>endTime){
                    endTime = arrival+laser[laserNum];
                }
            }
        }

        if(!q.isEmpty()){
            answer = Math.max(answer, q.size());
        }
        return answer;
    }


    public int getTime(String time){

        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);

        return (hour*60)+min;
    }

    public static void main(String[] args){
        sol3_4 T = new sol3_4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
