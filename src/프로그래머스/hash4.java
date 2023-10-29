package 프로그래머스;

import java.util.HashMap;

//의상
public class hash4 {

    public int solution(String[][] clothes) {

        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();


        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }

        for(String key : map.keySet()){
            answer *= map.get(key)+1;
        }

        //옷을 아예 안 입는 경우의 수는 없기 때문에 -1
        return answer-1;
    }


    public static void main(String[] args) {
        hash4 T = new hash4();

//        String[][] clothes = {{"crow_mask","face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}};
        String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(T.solution(clothes));
    }
}
