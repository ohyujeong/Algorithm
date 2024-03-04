package 프로그래머스2024;

import java.util.*;

//과일 장수
public class pro58 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        ArrayList<Integer> tmp;

        int j= 0;
        for(int i=score.length-1; i>0; i--){
            tmp = new ArrayList<>();
            for(; j<score.length; j++){
                if(i-j>=0){
                    tmp.add(score[i-j]);
                    if(tmp.size()==m){
                        answer += tmp.get(m-1) * m;
                        break;
                    };
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        pro58 T = new pro58();

        T.solution(4,3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
    }
}
