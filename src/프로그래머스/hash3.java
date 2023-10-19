package 프로그래머스;

import java.util.*;

//전화번호 목록
public class hash3 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Boolean> hm = new HashMap<>();

        for (String number : phone_book) {
            hm.put(number, true);
        }

        /*
        HashMap을 사용하여 문자열의 빠른 검색을 허용,
        키로 String을 사용하고 그 값으로 Boolean을 사용하여 각 전화번호가 포함되었는지 확인

        전화번호의 모든 가능한 접두사를 확인하고 HashMap에서 검색
         */
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


//시간초과
//    public static boolean solution(String[] phone_book) {
//            boolean answer = true;
//
//            HashMap<Integer, String> hm = new HashMap<>();
//
//            Arrays.sort(phone_book);
//
//            //contain은 포함되어 있는걸 보는거고 문제는 시작하는 문자열을 봐야 하니까 startsWith
//            for(int i=0; i<phone_book.length; i++){
//                hm.put(i, phone_book[i]);
//                for(int j=0; j<phone_book.length; j++){
//                    if(hm.get(i).startsWith(phone_book[j]) && !hm.get(i).equals(phone_book[j])) {
//                        return false;
//                    }
//                }
//            }
//
//            return answer;
//        }

    public static void main(String[] args){
        hash3 T = new hash3();

        System.out.println(hash3.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}
