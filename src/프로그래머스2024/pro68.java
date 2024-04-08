package 프로그래머스2024;

import java.util.*;

//디스크 컨트롤러
public class pro68 {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);

        int idx = 0;
        int cnt = 0;
        int total = 0;
        int end = 0;

        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0]<=end){
                pQ.add(jobs[idx++]);
            }

            if(pQ.isEmpty()){
                end = jobs[idx][0];
            }
            else{
                int[] cur = pQ.poll();
                total += cur[1] + end-cur[0];
                end += cur[1];
                cnt++;
            }
        }

        return total/jobs.length;
    }

    public static void main(String[] args){
        pro68 T =new pro68();

        T.solution(new int[][]{{0,3},{1,9},{2,6}});
    }
}
