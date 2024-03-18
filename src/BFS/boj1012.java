package BFS;

import java.util.*;

//유기농 배추
public class boj1012 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){

            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int i=0; i<k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;

            }

            Queue<int[]> q = new LinkedList<>();

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};

            int L = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        q.offer(new int[]{i,j});
                        visited[i][j] = true;
                        while(!q.isEmpty()){

                            int[] cur = q.poll();

                            for(int z=0; z<4; z++){
                                int nx = cur[0]+dx[z];
                                int ny = cur[1]+dy[z];

                                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && map[nx][ny]==1){
                                    visited[nx][ny] = true;
                                    q.offer(new int[]{nx,ny});
                                }
                            }
                        }
                        L++;
                    }

                }
            }

            System.out.println(L);
        }

    }

}
