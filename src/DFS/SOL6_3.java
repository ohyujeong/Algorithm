package DFS;

import java.lang.reflect.Array;
import java.util.*;


//인프런 대기업 유제 바둑대회
public class SOL6_3 {

    int N;
    int answer = Integer.MAX_VALUE;
    boolean[] ch;

    //흰 돌 A, 검은돌 B
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public void dfs(int depth, int start, int[][] cans){

        int sumA = 0;
        int sumB = 0;

        if(depth == N/2){

            for(int i=0; i<ch.length; i++){
                if(ch[i]){
                    A.push(i);
                }
                else{
                    B.push(i);
                }
            }

            for(int i=0; i<N/2; i++){
                sumA += cans[A.pop()][0];
                sumB += cans[B.pop()][1];
            }

            answer = Math.min(Math.abs(sumA - sumB), answer);

        }

        else{
            for(int i=start; i<N; i++){
                ch[i] = true;
                dfs(depth+1, i+1, cans);
                ch[i] = false;
            }
        }
    }

    public int solution(int[][] cans){
        N = cans.length;

        ch = new boolean[N];

        dfs(0, 0, cans);

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args){
        SOL6_3 T = new SOL6_3();


        int[][] arr = {{87,84},{66,78},{94,94},{93,87},{72,92},{78,63}};
        int[][] arr2 = {{10,20},{15,25},{35,23},{55,20}};
        int[][] arr3 = {{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}};


//        T.solution(arr);
//        T.solution(arr2);
        T.solution(arr3);
    }
}
