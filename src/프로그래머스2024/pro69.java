package 프로그래머스2024;

import java.util.*;

//주차요금 계산
public class pro69 {

    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> inHm = new HashMap<>();
        HashMap<String, Integer> outHm = new HashMap<>();

        for(String s : records){
            String hour = s.split(" ")[0];
            String carNum = s.split(" ")[1];
            String status = s.split(" ")[2];
            int time = changeTime(hour);
            if(status.equals("IN")){
                inHm.put(carNum, time);
            }
            else{
                int inTime = inHm.get(carNum);
                int period = time-inTime;
                outHm.put(carNum, outHm.getOrDefault(carNum, 0)+period);
                inHm.remove(carNum);
            }
        }

        for(String car : inHm.keySet()){
            int inTime = inHm.get(car);
            int outTime = changeTime("23:59");
            int period = outTime-inTime;
            outHm.put(car, outHm.getOrDefault(car, 0)+period);
        }


        ArrayList<String> keys = new ArrayList<>(outHm.keySet());
        Collections.sort(keys);

        int basic = fees[0];
        int basicMoney = fees[1];
        int additional = fees[2];
        int addMoney = fees[3];

        int[] answer = new int[keys.size()];
        int idx = 0;
        for(String car : keys){
            if(outHm.get(car)<=basic){
                answer[idx] = basicMoney;
            }
            else{
                double totalTime = outHm.get(car)-basic;
                double addTime = Math.ceil(totalTime/additional);
                double total = basicMoney+(addTime*addMoney);
                answer[idx] = (int) total;
            }
            idx++;
        }


        return answer;
    }

    private int changeTime(String time){
        String hour = time.split(":")[0];
        String min = time.split(":")[1];

        int result = (Integer.parseInt(hour)*60)+Integer.parseInt(min);
        return result;
    }

    public static void main(String[] args){
        pro69 T = new pro69();

        T.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
    }
}
