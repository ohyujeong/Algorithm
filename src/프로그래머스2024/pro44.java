package 프로그래머스2024;

import java.util.*;

//실패율
public class pro44 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        HashMap<Integer, Double> hm = new HashMap<>();

        //클리어하지 못하고 stage(key)에 머물러 있는 유저 수(value)
        for(int i : stages){
            if(i>N){
                continue;
            }
            hm.put(i, hm.getOrDefault(i, 0.0)+1);
        }

        //총 유저 수
        int user = stages.length;

        for(int i=1; i<N+1; i++){
            if(hm.containsKey(i)){
                double fail = hm.get(i);
                hm.put(i, fail/user);
                user-= (int) fail;
            }
            else{
                hm.put(i, 0.0);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

        keys.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));

        for(int i=0; i<N; i++){
            if(keys.get(i)>N){
                continue;
            }
            answer[i] = keys.get(i);
        }


        return answer;
    }

    public static void main(String[] args){
        pro44 T =new pro44();

        int[] test = {4,4,4,4,4};
        T.solution(4, test);
    }
}
