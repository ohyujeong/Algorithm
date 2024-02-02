package greedy;

import java.util.Arrays;
import java.util.Comparator;

//스프링 쿨러
public class SOL5_3 {

    public int solution(int n, int[] nums){
        int answer=0;

        int[][] lange = new int[nums.length+1][2];

        for(int i=0; i<nums.length; i++){
            lange[i][0] = Math.max(0, i-nums[i]);
            lange[i][1] = Math.min(n, i+nums[i]);
        }

        Arrays.sort(lange, (o1,o2) -> o1[0]-o2[0]);

        int start = 0;
        int end= 0;
        int i = 0;
        while(i<lange.length){
            while(i<lange.length && lange[i][0]<=start){
                end = Math.max(end, lange[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1;
            start = end;
        }

        return answer;
    }

    public static void main(String[] args){

        SOL5_3 T = new SOL5_3();


        int n = 5;
        int[] nums = {2, 0, 0, 0, 0, 2};

        T.solution(n,nums);

    }
}
