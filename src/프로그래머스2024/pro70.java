package 프로그래머스2024;

import java.util.*;

//파괴되지 않은 건물
public class pro70 {

    public int solution(int[][] board, int[][] skill) {

        int answer = 0;

        int row = board.length;
        int col = board[0].length;

        int[][] damage = new int[row+1][col+1];

        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];

            int r2 = skill[i][3];
            int c2 = skill[i][4];

            int degree = skill[i][5];

            if(type==1){
                damage[r1][c1]-=degree;
                damage[r2+1][c2+1]-=degree;

                damage[r1][c2+1]+=degree;
                damage[r2+1][c1]+=degree;
            }
            else{
                damage[r1][c1]+=degree;
                damage[r2+1][c2+1]+=degree;

                damage[r1][c2+1]-=degree;
                damage[r2+1][c1]-=degree;
            }
        }


        // 누적합 계산
        int[][] sum = new int[row+1][col+1];
        // 위->아래
        for(int i=0; i<row+1; i++) {
            sum[i][0] = damage[i][0];
            for(int j=1; j<col+1; j++) {
                sum[i][j] = damage[i][j] + sum[i][j - 1];
            }
        }
        // 왼->오
        for(int j=0; j<col+1; j++) {
            for(int i=1; i<row+1; i++){
                sum[i][j] += sum[i-1][j];
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]+=sum[i][j];
                if(board[i][j]>=1){
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }



    public static void main(String[] args){
        pro70 T = new pro70();

        T.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});
    }
}
