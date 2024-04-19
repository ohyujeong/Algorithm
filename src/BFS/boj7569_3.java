package BFS;

import java.util.*;
import java.io.*;

class Tomato{
    int h;
    int x;
    int y;
    public Tomato(int h, int x, int y){
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

public class boj7569_3 {

    static int M,N,H;

    static int[] dx ={0,0,1,-1,0,0};
    static int[] dy ={1,-1,0,0,0,0};

    //위 아래 이동
    static int[] dz ={0,0,0,0,-1,1};

    static int[][][] tomato;
    static boolean[][][] visited;

    static int ans = 0;

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k]==1){
                        q.offer(new Tomato(i,j,k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        //1 익은 토마토, 0 안 익음, -1 없음
        bfs();

        //다 익었으면 true, 안 익은 토마토 있으면 false 반환
        boolean flag = checkAll();
        if(flag){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }

    }

    static boolean checkAll(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(tomato[i][j][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void bfs(){

        while(!q.isEmpty()){

            boolean flag = false;
            int len = q.size();

            for(int s=0; s<len; s++){
                Tomato t = q.poll();
                for(int i=0; i<6; i++){
                    int nh = t.h+dz[i];
                    int nx = t.x+dx[i];
                    int ny = t.y+dy[i];

                    if(nh<0 || nh>=H || nx<0 || nx>=N || ny<0 || ny>=M){
                        continue;
                    }

                    if(!visited[nh][nx][ny] && tomato[nh][nx][ny]==0){
                        //새롭게 익은 토마토가 있으면 flag = true;
                        flag = true;
                        tomato[nh][nx][ny] =1;
                        visited[nh][nx][ny] = true;
                        q.offer(new Tomato(nh,nx,ny));
                    }
                }
            }

            //일수가 지났는데 새롭게 익은 토마토 없으면 날짜 안 더해야됨
            if(flag){
                ans++;
            }
        }
    }


}