package 다시풀기;

import java.util.*;
import java.io.*;

public class boj2206 {

    static int N,M;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int answer = 1;

    static class Wall{
        boolean wall;
        int x;
        int y;
        public Wall(boolean wall, int x, int y){
            this.wall = wall;
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N+1][M+1];

        //0은 벽을 부시지 않은 경우의 수로 방문 체크
        //1은 벽을 부순 경우의 수로 방문 체크
        visited = new boolean[2][N+1][M+1];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = str.charAt(j-1)-'0';
                map[i][j] = str.charAt(j-1)-'0';
            }
        }

        Queue<Wall> q = new LinkedList<>();

        //시작점
        q.offer(new Wall(false, 1, 1));

        visited[0][1][1] = true;
        visited[1][1][1] = true;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Wall cur = q.poll();
                if(cur.x==N && cur.y==M){
                    System.out.println(answer);
                    return;
                }
                for(int j=0; j<4; j++){

                    int nx = cur.x+dx[j];
                    int ny = cur.y+dy[j];

                    if(nx<=0 || nx>N || ny<=0 || ny>M){
                        continue;
                    }

                    //벽을 만났고, 벽을 부순적이 없으면 1번 부술 기회가 있음
                    if(map[nx][ny]==1 && !cur.wall){

                        //이 nx,ny로 진행되는 경우는 이제 벽을 부순 경우(true)임
                        q.offer(new Wall(true, nx,ny));

                        //벽을 부셨으니까 visited[1] 로 방문 체크
                        visited[1][nx][ny] = true;
                    }

                    else if(map[nx][ny]==0){

                        //이미 벽을 부셨을 경우에는 visited[1]로 방문 진행
                        if(cur.wall && !visited[1][nx][ny]){
                            q.offer(new Wall(true,nx,ny));
                            visited[1][nx][ny] = true;
                        }

                        //벽을 부시지 않은 경우에는 0으로 방문 진행
                        else if(!cur.wall && !visited[0][nx][ny]){
                            q.offer(new Wall(false, nx,ny));
                            visited[0][nx][ny] = true;
                        }
                    }
                }
            }
            answer++;
        }


        System.out.println(-1);


    }
}
