package 프로그래머스2024;

import java.util.*;

//햄버거 만들기
public class pro29 {
    public int solution(int[] ingredient) {

        int answer = 0;

        Stack<Integer> s = new Stack<>();

        int[] tmp = new int[4];

        int[] correct = new int[] {1,2,3,1};

        for(int i=0; i<ingredient.length; i++){
            s.push(ingredient[i]);
            if(s.peek()==1 && s.size()>3){
                for(int j=3; j>=0; j--){
                    tmp[j] = s.pop();
                }
                if(Arrays.equals(correct, tmp)){
                    answer++;
                }
                else{
                    for(int k=0; k<4; k++){
                        s.push(tmp[k]);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){

        pro29 T = new pro29();

        int[] test = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        T.solution(test);

    }
}
