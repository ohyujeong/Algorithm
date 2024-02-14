package BFS;

import java.util.*;


//집을 짓자
public class SOL7_5 {

    public int solution(int[][] board){

        int n = board.length;
        int[][] dis = new int[n][n];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<Point> q = new LinkedList<>();
        int emptyLand = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1) {

                    q.offer(new Point(i, j));
                    int L = 0;
                    while(!q.isEmpty()){
                        int len = q.size();
                        L++;
                        for(int r=0; r<len; r++){
                            Point tmp = q.poll();
                            for(int x=0; x<4; x++){
                                int nx = tmp.x+dx[x];
                                int ny = tmp.y+dy[x];
                                if(nx>=0 && nx<n && ny>=0 && ny<n){
                                    if(board[nx][ny]== emptyLand){
                                        board[nx][ny] --;
                                        q.offer(new Point(nx,ny));
                                        dis[nx][ny] +=L;
                                    }
                                }
                            }
                        }
                    }
                    emptyLand--;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == emptyLand){
                    answer = Math.min(answer,dis[i][j]);
                }
            }
        }

        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args){
        SOL7_5  T = new SOL7_5 ();
     System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
     System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
     System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
     System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
