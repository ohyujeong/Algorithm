package 프로그래머스;

import java.text.*;
import java.util.*;

public class kakao01 {


    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar cal = Calendar.getInstance();

        //String으로 들어온 날짜를 date형으로 변경
        Date todayDate = new Date(dateFormat.parse(today).getTime());
        Date[] termsDate = new Date[privacies.length];

        for(int i=0; i< termsDate.length; i++){
            String tmp = privacies[i].split(" ")[0];
            termsDate[i] = new Date(dateFormat.parse(tmp).getTime());
        }


        HashMap<String, Integer> termsHash = new HashMap<>();

        for(int i=0; i<terms.length; i++){
            String key = terms[i].split(" ")[0];
            int value = Integer.parseInt(terms[i].split(" ")[1]);

            termsHash.put(key, value);
        }

        //종류별로 유효기간 더한 날짜
        HashMap<Integer, Date> map = new HashMap<>();

        for(int i=0; i< privacies.length; i++){

            String kind = privacies[i].split(" ")[1];
            int term = termsHash.get(kind);

            cal.setTime(termsDate[i]);
            cal.add(Calendar.MONTH, term);
            cal.add(Calendar.DATE, -1);

            Date afterDate = cal.getTime();
            map.put(i+1, afterDate);
        }


        ArrayList<Integer> answerList = new ArrayList<>();


        for(int i=0; i<privacies.length; i++){
            if(map.get(i+1).before(todayDate)){
                answerList.add(i+1);
            }
        }


        int[] answer = new int[answerList.size()];

        for(int i=0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
            System.out.println(answer[i]);
        }

        return answer;

    }


    public static void main(String[] args) throws ParseException {
        kakao01 T = new kakao01();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        T.solution(today, terms, privacies);

    }
}
