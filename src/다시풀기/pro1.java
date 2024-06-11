package 다시풀기;

import java.util.*;

//전화번호 목록
public class pro1 {

    class Solution {
        public boolean solution(String[] phone_book) {

            boolean answer = true;
            HashMap<String, Boolean> hm = new HashMap<>();

            for (String number : phone_book) {
                hm.put(number, true);
            }

            for (String number : phone_book) {
                for (int i = 1; i < number.length(); i++) {
                    String prefix = number.substring(0, i);
                    if (hm.containsKey(prefix)) {
                        answer = false;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
