package 프로그래머스2024;

import java.util.*;

//키패드 누르기
public class pro30 {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[][] key = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};

        HashMap<Integer, int[]> keypad = new HashMap<>();
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                keypad.put(key[i][j], new int[]{i,j});
            }
        }

        //시작 위치
        int L = -1;
        int R = -2;
        int index = 0;
        for(int i : numbers){
            int[] cur = keypad.get(i);
            //왼손
            if(cur[1]==0){
                answer.append("L");
            }
            //오른손
            if(cur[1]==2){
                answer.append("R");
            }
            //거리 비교
            if(cur[1]==1){
                int disL = Math.abs(keypad.get(L)[0]-cur[0])+Math.abs(keypad.get(L)[1]-1);
                int disR = Math.abs(keypad.get(R)[0]-cur[0])+Math.abs(keypad.get(R)[1]-1);
                if(disL>disR){
                    answer.append("R");
                }
                if(disL<disR){
                    answer.append("L");
                }
                if(disL==disR){
                    if(hand.equals("right")){
                        answer.append("R");
                    }
                    if(hand.equals("left")){
                        answer.append("L");
                    }
                }
            }
            if(answer.charAt(index)=='R'){
                R = i;
            }
            else{
                L = i;
            }
            index++;
        }


        return answer.toString();
    }

    public static void main(String[] args){

        pro30 T = new pro30();

        int[] test = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(T.solution(test,hand));
    }
}
