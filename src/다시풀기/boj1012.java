package 다시풀기;

import java.util.*;
import java.io.*;

public class boj1012 {

    static int N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;

    static void bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        map[x][y] = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }

                if(map[nx][ny]==1){
                    map[nx][ny]=-1;
                    q.offer(new int[]{nx,ny});
                }
            }

        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            //가로
            M = Integer.parseInt(st.nextToken());
            //세로
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int cnt=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1){
                        cnt++;
                        bfs(i,j);
                    }
                }
            }

            System.out.println(cnt);


        }


    }
}
