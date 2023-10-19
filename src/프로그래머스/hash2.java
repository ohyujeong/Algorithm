package 프로그래머스;

import java.util.HashMap;

//완주하지 못한 선수
public class hash2 {

    public String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();


        for (String s : participant) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        for(String s : completion){
            hm.put(s, hm.get(s)-1);
            if(hm.get(s) == 0){
                hm.remove(s);
            }
        }

        for(String s : participant){
            if(hm.containsKey(s)){
                answer = s;
            }
        }

        return answer;

    }

    public static void main(String[] args){
        hash2 T = new hash2();

        String[] arr = {"leo", "kiki", "eden"};
        String[] arr2 = {"eden", "kiki"};

        System.out.println(T.solution(arr,arr2));
    }
}
