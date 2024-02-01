package 프로그래머스2024;

import java.util.HashMap;

// 추억 점수
public class pro9 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<name.length; i++){
            hm.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(hm.containsKey(photo[i][j])){
                    answer[i] += hm.get(photo[i][j]);
                }
            }
        }

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        pro9 T = new pro9();

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5,10,1,3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        T.solution(name, yearning, photo);
    }
}
