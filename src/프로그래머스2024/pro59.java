package 프로그래머스2024;

import java.util.*;

//개인정보 수집 유효기간
public class pro59 {

    public int[] solution(String today, String[] terms, String[] privacies) {


        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> termHm = new HashMap<>();

        for(String s : terms){
            String key = s.split(" ")[0];
            int time = MonthToTime(s.split(" ")[1]);
            termHm.put(key, time);
        }

        int cur = getTime(today);

        for(int i=0; i<privacies.length; i++){
            String s = privacies[i];
            int time = getTime(s.split(" ")[0]);
            int term = termHm.get(s.split(" ")[1]);

            if((time+term)<=cur){
                result.add(i+1);
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public int getTime(String privacy){
        int year = Integer.parseInt(privacy.split("\\.")[0].substring(2));
        int month = Integer.parseInt(privacy.split("\\.")[1]);
        int day = Integer.parseInt(privacy.split("\\.")[2]);
        return (year*28*12) + (month*28) + (day);
    }

    public int MonthToTime(String month){
        return Integer.parseInt(month) * 28;
    }

    public static void main(String[] args){

        pro59 T = new pro59();

        T.solution("2020.01.01", new String[] {"Z 3", "D 5"}, new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
    }
}
