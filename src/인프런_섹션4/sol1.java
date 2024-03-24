package 인프런_섹션4;

import java.util.*;
class sol1 {
    public int[] solution(int[] nums){

        int[] answer = new int[nums.length];

       int[][] arr = new int[nums.length][2];

        for(int i=0; i<nums.length; i++){
            String binary = Integer.toBinaryString(nums[i]);
            int cnt = 0;
            for(char x : binary.toCharArray()){
                if(x=='1'){
                    cnt++;
                }
            }
            arr[i][0] = nums[i];
            arr[i][1] = cnt;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]-o2[1]==0){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });


        for(int i=0; i<nums.length; i++){
            answer[i]=arr[i][0];
        }



        return answer;
    }

    public static void main(String[] args){
        sol1  T = new sol1 ();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}