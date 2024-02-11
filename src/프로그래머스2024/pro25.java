package 프로그래머스2024;

import java.util.*;

//모의고사 - 완전탐색
public class pro25 {
    public int[] solution(int[] answers) {


        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, int[]> hm = new HashMap<>();

        hm.put(1, new int[]{1,2,3,4,5});
        hm.put(2, new int[]{2,1,2,3,2,4,2,5});
        hm.put(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        HashMap<Integer, Integer> result = new HashMap<>();

        //1 2 3 4 5 1 2 3 4 5 ...
        //1 2 3 4 5 1 2 3 4
        for(int i=0; i<answers.length; i++){
            int num = i;
            for(int x : hm.keySet()){
                if(i>=hm.get(x).length){
                  num%=hm.get(x).length;
                }
                if(answers[i]==hm.get(x)[num]){
                    result.put(x, result.getOrDefault(x, 0)+1);
                }
                num=i;
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(result.entrySet());
        entryList.sort((o1, o2) -> o2.getValue()-o1.getValue());

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : entryList){
            max = Math.max(max, entry.getValue());
            if(max>entry.getValue()){
                continue;
            }
            list.add(entry.getKey());
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }


    public static void main(String[] args){
        pro25 T = new pro25();

        //1번 학생은5개, 2번 학생은 1개 , 3번학생은 5개
        System.out.println(Arrays.toString(T.solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1,3,2,4,2})));
    }
}
