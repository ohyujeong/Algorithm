package 프로그래머스2024;

import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

//석유 시추
public class pro4_2 {

    public Queue<Point> q = new LinkedList<>();
    public int[][] dis;
    public int n,m;

    public int[] dx = {1,0,-1,0};
    public int[] dy = {0,-1,0,1};

    int[] result;
    boolean[] visited;

    int cnt;

    public void bfs(int[][] land){

        cnt = 0;

        while(!q.isEmpty()){
            Point tmp = q.poll();
            visited[tmp.y] = true;
            for(int i=0; i<4; i++){

                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && land[nx][ny] ==1){
                    land[nx][ny]=land[tmp.x][tmp.y]+1;
                    q.offer(new Point(nx,ny));
                    cnt++;
                }
            }
        }

        for(int i=0; i<m; i++){
            if(visited[i]){
                if(cnt==0){
                    result[i]+=1;
                }
                else{
                    result[i] += cnt;
                }
                visited[i] = false;
            }
        }

    }

    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;

        dis = new int[n][m];

        result = new int[m];
        visited = new boolean[m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1){
                    q.offer(new Point(i,j));
                    bfs(land);
                }
            }
        }


        for(int i=0; i<m; i++){
           answer = Math.max(answer, result[i]);
        }


        return answer;
    }


    public static void main(String[] args){
        pro4_2 T = new pro4_2();

        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
//        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
        T.solution(land);
    }
}
