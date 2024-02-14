package 프로그래머스2024;

import java.util.*;

//조이스틱
public class pro24 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        int index; //다음 값 확인
        int move = len-1; // 좌우 움직임 체크


        for(int i=0; i<len; i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            index = i+1;

            //연속되는 A갯수
            while(index<len && name.charAt(index)=='A'){
                index++;
            }

            move = Math.min(move, i*2+len-index);
            move = Math.min(move, (len-index) *2 +i);
        }


        return answer+move;
    }

    public static void main(String[] args){
        pro24 T = new pro24();

        T.solution("JEROEN");
    }
}
