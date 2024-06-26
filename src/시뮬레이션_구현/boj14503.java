package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//로봇 청소기
public class boj14503 {

    static int n,m;
    static int[][] map;

    //북 동 남 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int cnt=1;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[r][c]=2;
        clean(r,c,d);

        System.out.println(cnt);
    }

    static void clean(int x, int y, int dir){

        map[x][y] = -1;

        for(int i = 0; i < 4; i++) {

            //반시계 방향 회전
            //0->3 , 1->0 , 2->1 , 3->2
            //0에 3더하고 4로 나눈 나머지값 => 3
            //1에 3더하고 4로 나눈 나머지값 => 0 (...)
            dir = (dir+3)%4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //반시계 방향으로 회전한 칸이 청소되지 않았으면
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(map[nx][ny] == 0) {
                    cnt++;
                    //해당칸으로 전진해서 다시 청소시작
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < n&& by < m && map[bx][by] != 1) {
            clean(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }

}
