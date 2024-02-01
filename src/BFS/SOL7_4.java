package BFS;

import java.util.LinkedList;
import java.util.Queue;

//미로의 최단거리 통로
public class SOL7_4 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    Queue<Point> q = new LinkedList<>();

    public int solution(int[][] board){

        int n  = board.length;
        int m = board[0].length;
        int[][] dir = new int[n][m];

        q.offer(new Point(0,0));

        while(!q.isEmpty()){
            Point tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                    q.offer(new Point(nx,ny));
                    board[nx][ny] = 1;
                    dir[nx][ny] = dir[tmp.x][tmp.y]+1;
                }
            }
        }

        if(dir[n-1][m-1]>0){
            System.out.println(dir[n-1][m-1]);
            return dir[n-1][m-1];
        }
        else{
            System.out.println(-1);
            return -1;
        }
    }

    public static void main(String[] args){
        SOL7_4 T = new SOL7_4();

        int[][] arr = {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 0, 0, 0}};

        T.solution(arr);

//        int[][] arr2 = {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0,
//                0, 0},{1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0,
//                0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}};
//
//        T.solution(arr2);
    }
}
