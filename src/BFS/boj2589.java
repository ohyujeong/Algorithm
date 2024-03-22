package BFS;

import java.io.*;
import java.util.*;

//보물섬
public class boj2589 {


    static int[] dx = {0,0,1,-1};
    static int[] dy ={1,-1,0,0};

    static Queue<int[]> q= new LinkedList<>();
    static char[][] map;
    static int max = 0;

    static boolean[][] visited;
    static int n,m;

    public static void bfs(){
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();

            while(len-->0){

                int[] cur = q.poll();

                for(int k=0; k<4; k++){
                    int nx = cur[0]+dx[k];
                    int ny = cur[1]+dy[k];

                    if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]=='L' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            L++;
        }
        max = Math.max(max, L);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0; i<n; i++){
            map[i]=br.readLine().toCharArray();
        }

        //시작점에서 레벨탐색이 가장 길게 되는 게 시작점-도착점 거리 가장 긴 거임
        //가능한 시작점을 모두 돌면서 레벨 max 값을 찾음
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='L'){
                    //시작점마다 visited 새로 체크해야 하니까 초기화
                    visited = new boolean[n][m];
                    q.offer(new int[]{i,j});
                    //시작점 방문처리
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        System.out.println(max-1);

    }
}
