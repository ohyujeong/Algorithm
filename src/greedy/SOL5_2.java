package greedy;

import java.util.*;


//이동 횟수
public class SOL5_2 {

    public int solution(int[] nums){

        int answer = 0;

        Arrays.sort(nums);

        int left = 0 ;
        int right = nums.length-1;


        while(left<=right){
            if(nums[left] + nums[right] <=5){
                answer++;
                left++;
                right--;
            }
            else{
                answer++;
                right--;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){

        SOL5_2 T = new SOL5_2();

        int[] nums = {3, 3, 3, 3, 3};

        T.solution(nums);

    }
}
