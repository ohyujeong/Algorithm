package greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//침몰하는 타이타닉(인프런)
public class SOL5_1 {

    public int solution(int[] nums, int m){

        int answer = 0;

        Arrays.sort(nums);

        Deque<Integer> q = new ArrayDeque<>();
        for(int i : nums){
            q.add(i);
        }

        while(!q.isEmpty()){
            //가장 작은 수랑 가장 큰 수 합이 M 이하면 2명 태움
            if(q.getFirst() + q.getLast()<=m){
                answer++;
                q.removeFirst();
                q.removeLast();
            }
            //가장 작은 수랑 더해도 M 이상이면 가장 큰 수는 혼자 타야됨
            else{
                answer++;
                q.removeLast();
            }
        }

        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args){

        SOL5_1 T = new SOL5_1();


        int[] arr = {68, 72, 30, 105, 55, 115, 36, 67, 119, 111,
                95, 24, 25, 80, 55, 85, 75, 83, 21, 81};
        int m= 120;

        T.solution(arr, m);

    }
}
