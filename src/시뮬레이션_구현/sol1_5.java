package 시뮬레이션_구현;

import java.util.*;

//최대길이 바이토닉 수열
public class sol1_5 {

    public int solution(int[] nums){

        int answer = 0;

        ArrayList<Integer> centerIdx = new ArrayList<>();

        int n = nums.length;
        for(int i=1; i<n-1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                centerIdx.add(i);
            }
        }

        for(int i=0; i<centerIdx.size(); i++){
            int center = centerIdx.get(i);

            int left = center-1;
            int right = center+1;

            int cnt = 3;

            while (left>0) {
                if(nums[left-1]<nums[left]){
                    left--;
                    cnt++;
                }
                else{
                    break;
                }
            }

            while (right<n-1) {
                if(nums[right+1]<nums[right]){
                    right++;
                    cnt++;
                }
                else{
                    break;
                }
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        sol1_5 T = new sol1_5();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }

}
