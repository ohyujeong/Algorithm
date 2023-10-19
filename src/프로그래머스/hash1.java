package 프로그래머스;

import java.util.*;

//폰켓몬
class hash1 {
    public int solution(int[] nums) {
        int n = nums.length/2;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        if(hm.size()>n){
            return n;
        }

        return hm.size();
    }
}
