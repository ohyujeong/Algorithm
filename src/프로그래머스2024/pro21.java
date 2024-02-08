package 프로그래머스2024;

import java.util.HashMap;

//대충 만든 자판
public class pro21 {

    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        HashMap<Character, Integer> hm = new HashMap<>();
        for(String s : keymap){
            for(int i=0; i<s.toCharArray().length; i++){
                char x = s.charAt(i);
                if(hm.containsKey(x) && hm.get(x)>i+1){
                    hm.put(x, i+1);
                }
                hm.putIfAbsent(x, i+1);
            }
        }

        for(int i=0; i<targets.length; i++){
            int cnt = 0;
            for(char x : targets[i].toCharArray()){
                if(!hm.containsKey(x)){
                    answer[i] = -1;
                    break;
                }
                else{
                    cnt += hm.get(x);
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        pro21 T = new pro21();

//        String[] keymap = {"ABACD", "BCEFD"};
//        String[] target = {"ABCD","AABB"};

        String[] keymap = {"AA"};
         String[] target = {"BB"};
        T.solution(keymap, target);
    }
}
