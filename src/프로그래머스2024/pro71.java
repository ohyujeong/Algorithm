package 프로그래머스2024;

import java.util.*;

//LRU 캐시
public class pro71 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<Integer, String> q = new HashMap<>();

        if(cacheSize==0){
            answer = 5*cities.length;
            return answer;
        }

        if(cacheSize>=cities.length){
            for(String s : cities){
                String city = s.toLowerCase(Locale.ROOT);
                if(!hm.containsKey(city)){
                    hm.put(city,1);
                    answer+=5;
                }
                else{
                    answer++;
                }
            }
            System.out.println(answer);
            return answer;
        }

        //recent 숫자가 제일 큰게 최근에 참조, 제일 작은게 오래 참조되지 않은 것
        int recent = 0;
        for(int i=0; i<cacheSize; i++){
            String city = cities[i].toLowerCase(Locale.ROOT);
            //cache miss
            if(!hm.containsKey(city)){
                answer+=5;
            }
            //cache hit
            else{
                answer++;
            }
            hm.put(city,recent);
            q.put(recent, city);
            recent++;
        }


        for(int i=cacheSize; i<cities.length; i++){
            String city = cities[i].toLowerCase(Locale.ROOT);
            if(!hm.containsKey(city)) {
                if (hm.size()==cacheSize) {
                    List<Integer> values = new ArrayList<>(hm.values());

                    //오름차순 정렬 가장 앞에 있는게 빼야 할 시티(가장 오래 찾지 않은 것)
                    Collections.sort(values);
                    //빼주고
                    hm.remove(q.get(values.get(0)));

                    //새로 넣어줌
                    hm.put(city, recent);
                    q.put(recent, city);
                }
                answer += 5;
            }
            else{
                answer++;
            }
            hm.put(city, recent);
            q.put(recent, city);
            recent++;
        }


        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        pro71 T = new pro71();
//
//        T.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
//        T.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
//        T.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
//        T.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
//        T.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
        T.solution(5, new String[]{ "a", "b", "c", "a"});

    }
}
