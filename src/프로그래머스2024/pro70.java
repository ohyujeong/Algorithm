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
                degree*=-1;
            }
            damage[r1][c1]+=degree;
            damage[r2+1][c2+1]+=degree;

            damage[r1][c2+1]-=degree;
            damage[r2+1][c1]-=degree;
        }


        for(int c=1; c<col; c++){
            for(int r=0; r<row; r++){
                damage[r][c] += damage[r][c-1];
            }
        }

        for(int r=1; r<row; r++){
            for(int c=0; c<col; c++){
                damage[r][c] += damage[r-1][c];
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                board[i][j] += damage[i][j];
                if(board[i][j]>=1){
                    answer++;
                }
            }
        }
        return answer;
    }



    public static void main(String[] args){
        pro70 T = new pro70();

        T.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});
    }
}
