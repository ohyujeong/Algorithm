package 자료구조;

import java.util.*;

//스택
public class SOL5_3 {

    public int solution(int[][] board, int[] moves, int N, int M){

        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        //크레인은 moves의 길이 = M만큼 작동시킴
        for(int i=0; i<M; i++){
            //board에 담긴 인형을 빼오기 위한 for문
            for(int j=0; j<N; j++){
                //배열은 0부터 시작함으로, moves[i] 에서 -1를 해줌
                //인형은 세로로 쌓이니까.. j값을 ++하면서 0이 아닌 값(인형이 있는 곳)을 찾음
                if(board[j][moves[i]-1] !=0){
                    //스택 맨 위의 값과 인형의 값이 같으면 스택 맨 위 값을 빼주고 인형은 2개 터지는거니까
                    //answer +=2
                    if(!stack.isEmpty() && stack.peek() == board[j][moves[i]-1]){
                        stack.pop();
                        answer+=2;
                    }
                    //스택 맨 위의 값과 같지 않으면 인형을 스택에 쌓아줌
                    else{
                        stack.push(board[j][moves[i]-1]);
                    }
                    //board에서 인형을 빼냈으니까 0으로 값을 넣어줌
                    board[j][moves[i]-1] = 0;
                    //다시 크레인을 돌기 위해 break하고 i++를 시켜줌
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args){

        SOL5_3 T = new SOL5_3();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();
        int[] moves = new int[M];

        for(int i=0; i<M; i++){
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(board, moves, N, M));
    }
}
