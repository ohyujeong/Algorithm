package 시뮬레이션_구현;

import java.util.*;

//사다리 타기
public class sol1_1 {

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        int line = ladder.length; //세로줄 개수
        boolean[][] graph = new boolean[line][n];


        for(int i=0; i<ladder.length; i++){
            for(int j=0; j<ladder[i].length; j++){
                graph[i][ladder[i][j]-1]= true;
            }
        }

        char alpha = 65;

        for(int i=0; i<n; i++){
            //시작점은 i번째 출발점
            int col = i;
            int row = 0;
            //마지막 가로막대까지 다 건너면 도착
            while(row<line){
                //오른쪽으로 이동
                if(graph[row][col]){
                    col++;
                }
                //왼쪽으로 이동 (왼쪽(col-1)으로 연결된 가로막대 있으면)
                else if(col>0 && graph[row][col-1]){
                    col--;
                }
                //한 번 이동하면 가로막대는 다음거 건너야됨 +1
                row++;
            }
            answer[col]=alpha;
            alpha++;
        }

        return answer;
    }

    public static void main(String[] args){
        sol1_1 T = new sol1_1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
       System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
       System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

}
