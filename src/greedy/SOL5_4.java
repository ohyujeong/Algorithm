package greedy;

import java.util.Arrays;

//꽃이 피는 최단시간
public class SOL5_4 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;

        Arrays.sort(plantTime);
        Arrays.sort(growTime);

        if(plantTime[0]==plantTime[plantTime.length-1]){
            answer = plantTime[0]+growTime[growTime.length-1];
            return answer;
        }

        for(int i : plantTime){
            answer +=i;
        }

        answer+=growTime[0];
        return answer;
    }

    public static void main(String[] args){
        SOL5_4 T = new SOL5_4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}

