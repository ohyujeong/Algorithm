package BFS;

import java.util.*;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


//미로의 최단거리 통로
public class SOL8_11 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, dis;

    public void bfs(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));

        //출발점 1로 체크해줌
        board[x][y] = 1;

        while(!Q.isEmpty()){
            //현재 지점
            Point tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args){
        SOL8_11 T = new SOL8_11();


        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        dis = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = sc.nextInt();
            }
        }

        T.bfs(1,1);

        if(dis[7][7] == 0 ){
            System.out.println(-1);
        }
        else{
            System.out.println(dis[7][7]);
        }
    }
}
