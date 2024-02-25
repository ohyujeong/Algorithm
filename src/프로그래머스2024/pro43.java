package 프로그래머스2024;

import java.util.*;

//로또의 최고 순위와 최저 순위
public class pro43 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(6,1);
        result.put(5,2);
        result.put(4,3);
        result.put(3,4);
        result.put(2,5);

        HashMap<Integer, Integer> lotto = new HashMap<>();
        for(int i : lottos){
            lotto.put(i, lotto.getOrDefault(i, 0)+1);
        }

        for(int i : win_nums){
            if(lotto.containsKey(i)){
                answer[1]++;
                answer[0]++;
            }
        }


        if(lotto.containsKey(0)){
            answer[0] += lotto.get(0);
        }

        for(int i=0; i<2; i++){
            if(answer[i]<2){
                answer[i] = 6;
            }
            else{
                answer[i] = result.get(answer[i]);
            }
        }


        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public static void main(String[] args){
        pro43 T = new pro43();

        int[] test = {44, 1, 0, 0, 31, 25};
        int[] test2 = {31, 10, 45, 1, 6, 19};
        T.solution(test,test2);
    }
}
