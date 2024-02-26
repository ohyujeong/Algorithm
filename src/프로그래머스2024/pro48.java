package 프로그래머스2024;

import java.util.*;

//소수 만들기
public class pro48 {

    boolean[] visited;
    int answer = 0;

    public void dfs(int depth, int[] nums, int sum, int start){

        if(depth==3){

            if(isPrime(sum)) {
                answer++;
            }
            return;
        }


        for(int i=start; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, nums, sum+nums[i], i+1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n){

        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i ==0) return false;
        }
        return true;
    }

    public int solution(int[] nums) {

        visited = new boolean[nums.length];
        dfs(0, nums, 0, 0);

        return answer;
    }

    public static void main(String[] args){

        pro48 T = new pro48();

//        T.solution(new int[]{1,2,3,4});
        T.solution(new int[]{1,2,7,6,4});
    }
}
