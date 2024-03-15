package BFS;

import java.util.*;
import java.io.*;

//쉬운 최단 거리
public class boj14940 {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int arrivalX = 0;
        int arrivalY = 0;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    arrivalX = i;
                    arrivalY = j;
                }
            }
        }

        int[][] answer = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        //목표 지점에서부터 거리를 측정
        q.offer(new int[]{arrivalX,arrivalY});
        visited[arrivalX][arrivalY] = true;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){

            int[] cur = q.poll();

            for(int k=0; k<4; k++){
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];

                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    answer[nx][ny]= answer[cur[0]][cur[1]]+1;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bw.write(String.valueOf(answer[i][j]));
                bw.write(" ");
            }
            bw.newLine();
        }

        bw.close();

    }
}
