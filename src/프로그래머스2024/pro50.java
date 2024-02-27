package 프로그래머스2024;

import java.util.*;

//캐시
public class pro50 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize==0){
            answer = cities.length * 5;
            return answer;
        }


        Deque<String> q = new LinkedList<>();

        int start = 0;
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase(Locale.ROOT);
            if(q.size()!=cacheSize){
                start++;
                if(q.contains(city)){
                    q.remove(city);
                    q.addLast(city);
                    answer++;
                    continue;
                }
                q.add(city);
                answer+=5;
            }
        }

        for(int i=start; i<cities.length; i++){
            String city = cities[i].toLowerCase(Locale.ROOT);
            if(q.contains(city)){
                q.remove(city);
                q.addLast(city);
                answer++;
            }
            else{
                q.pollFirst();
                q.addLast(city);
                answer+=5;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        pro50 T = new pro50();

        System.out.println(T.solution(3, new String[]{"A","B","A","C"}));
    }
}
