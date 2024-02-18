package 프로그래머스2024;

import java.util.*;

//압축
public class pro31 {

    public int[] solution(String msg) {

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<String, Integer> dic = new HashMap<>();

        for(int i=0; i<26; i++){
            char alpha = (char)((char) 65+i);
            dic.put(Character.toString(alpha), i+1);
        }


        ArrayList<String> s = new ArrayList<>();
        for(char c : msg.toCharArray()){
            s.add(Character.toString(c));
        }

        int index = 26;
        StringBuilder sb = new StringBuilder();

        int n = msg.length();

        int L = 0;

        while(n>0){

            sb.append(s.get(L));
            String word = s.get(L);

            for(int i=L+1; i<s.size(); i++){
                if(dic.containsKey(sb.toString())){
                    word = sb.toString();
                    sb.append(s.get(i));
                }
                else{
                    break;
                }
            }

            if(dic.containsKey(sb.toString())){
                word = sb.toString();
            }

            int next = word.length();
            result.add(dic.get(word));
            dic.put(sb.toString(), index+1);
            index++;
            sb.setLength(0);
            L+=next;
            n-=next;

        }


        int[] answer = new int[result.size()];

        for(int i=0; i<answer.length; i++){
            answer[i]=result.get(i);
        }

        return answer;
    }


    public static void main(String[] args){
        pro31 T = new pro31();

        T.solution("TOBEORNOTTOBEORTOBEORNOT");
    }
}
