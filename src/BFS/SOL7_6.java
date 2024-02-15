package BFS;

import java.util.*;

public class SOL7_6 {
    public int solution(int[][] board){

        int R = board.length;
        int C = board[0].length;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<int[]> q = new LinkedList<>();

        int[][] dis = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j]==2 || board[i][j]==3){
                    q.offer(new int[]{i,j});
                    int L = 0;
                    boolean[][] ch = new boolean[R][C];
                    ch[i][j] = true;
                    while(!q.isEmpty()){
                        int len = q.size();
                        L++;
                        for(int x=0; x<len; x++){
                            int[] tmp = q.poll();
                            for(int k=0; k<4; k++){
                                int nx = tmp[0]+dx[k];
                                int ny = tmp[1]+dy[k];
                                if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]!=1 && !ch[nx][ny]) {
                                    q.offer(new int[]{nx, ny});
                                    dis[nx][ny] += L;
                                    ch[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }


        int answer = Integer.MAX_VALUE;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j]==4){
                    answer = Math.min(answer, dis[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        SOL7_6 T = new SOL7_6();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
