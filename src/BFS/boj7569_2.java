package BFS;

import java.util.*;

//토마토 3차원 풀이
public class boj7569_2 {

    static int N,M,H;
    static Queue<int[]> q = new LinkedList<>();

    static boolean[][][] visited;
    static int[][][] tomato;
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int zeroCnt = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    tomato[i][j][k] = sc.nextInt();
                    if(tomato[i][j][k]==1){
                        //행,열, 차원
                        q.offer(new int[]{j,k,i});
                        visited[i][j][k]=true;
                    }
                    if(tomato[i][j][k]==0){
                        zeroCnt++;
                    }
                }
            }
        }

        //bfs 하기 전에 이미 다 익은 경우 (0이 0개)
        if(zeroCnt==0){
            System.out.println(0);
            return;
        }

        int answer = bfs();

        //bfs 돌리면서 하나 익을 때마다 zeroCnt -1 해줌
        //bfs 돌린 후에도 zeroCnt가 0보다 크면 안 익은 토마토 존재
        if(zeroCnt>0){
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static int bfs(){

        int L = 0;

        while(!q.isEmpty()){
            boolean flag = false;
            int len = q.size();

            for(int i=0; i<len; i++){
                int[] cur = q.poll();

                int x = cur[0];
                int y = cur[1];
                int z = cur[2];

                for(int j=0; j<6; j++){

                    int nx = x+dx[j];
                    int ny = y+dy[j];
                    int nz = z+dz[j];

                    if(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H && tomato[nz][nx][ny]==0 && !visited[nz][nx][ny]){
                        visited[nz][nx][ny] = true;
                        q.offer(new int[]{nx,ny,nz});
                        flag = true;
                        zeroCnt--;
                    };
                }
            }
            //토마토가 새롭게 익었을 때만 L++
            if(flag){
                L++;
            }
        }

        return L;
    }
}
