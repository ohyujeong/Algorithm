package 다시풀기;

import java.util.*;
import java.io.*;

public class boj13565 {

    static int M,N;
    static int[][] map;
    static boolean flag = false;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static Queue<int[]> q = new LinkedList<>();

    static void bfs(){

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N){
                    continue;
                }

                if(map[nx][ny]==0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        //가장 마지막 행까지 도달했으면 flag true
        for(int i=0; i<N; i++){
            if (visited[M - 1][i]) {
                flag = true;
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        //0 -> 전류 통함
        //1-> 전류 X
        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                int x = str.charAt(j)-'0';
                map[i][j] = x;
            }
        }

        //전류는 outside에서 시작되니까 가장 처음 행에서 열만 0,1,...N-1까지 탐색
        //전류 흘러올 수 있는 0 있으면 bfs 시작

        for(int i=0; i<N; i++){
            if(map[0][i]==0){
                q.offer(new int[]{0,i});
                visited[0][i]=true;
                bfs();
            }
        }


        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
