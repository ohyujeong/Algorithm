package 프로그래머스;

import java.util.*;

class Point{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class bfs1 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point> q = new LinkedList<>();

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        int[][] dis = new int[maps.length][maps[0].length];
        int answer = 0;

        //출발점
        q.offer(new Point(0,0));

        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }

        if(maps[n-1][m-1] == 1){
            answer = -1;
        }
        else{
            answer = dis[n-1][m-1] + 1;
        }

        return answer;
    }

    public static void main(String[] args){
        bfs1 T = new bfs1();

        int[][] maps ={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(T.solution(maps));

    }

}
