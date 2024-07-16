package 다시풀기;

import java.util.*;
import java.io.*;

class goosle{

    int redX;
    int redY;
    int blueX;
    int blueY;
    int cnt;

    public goosle(int redX, int redY, int blueX, int blueY, int cnt){
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.cnt = cnt;
    }
}

public class boj13460{

    //오, 왼, 위, 아래
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N,M;
    static char[][] board;
    static int answer = 0;
    static Queue<goosle> q = new LinkedList<>();
    static boolean[][][][] visited;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        //빨간 구슬, 파란 구슬 좌표 같이 체크크
        visited = new boolean[N][M][N][M];

        goosle gs = new goosle(0,0,0,0,0);

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j]=s.charAt(j);
                if(board[i][j]=='R'){
                    gs.redX=i;
                    gs.redY=j;
                }
                if(board[i][j]=='B'){
                    gs.blueX=i;
                    gs.blueY=j;
                }
            }
        }

        q.offer(gs);
        visited[gs.redX][gs.redY][gs.blueX][gs.blueY]=true;

        System.out.println(bfs());
    }

    static int bfs(){
        while(!q.isEmpty()) {
            goosle cur = q.poll();

            if (cur.cnt == 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int rx = cur.redX;
                int ry = cur.redY;
                int bx = cur.blueX;
                int by = cur.blueY;
                int cnt = cur.cnt;

                boolean isRedHole = false;
                boolean isBlueHole = false;
                //#만날 때까지 같은 방향으로 빨간 구슬 이동
                while (true) {
                    int nextRx = rx + dx[i];
                    int nextRy = ry + dy[i];
                    if (board[nextRx][nextRy] == '#') {
                        break;
                    }
                    //빨간 구슬이 구멍과 같은 좌표에 도착한 경우.. 체크
                    if (board[nextRx][nextRy] == 'O') {
                        isRedHole = true;
                        break;
                    }
                    //next 움직인 곳으로 빨간구슬 좌표 수정해서 계속 같은 방향으로 이동
                    rx = nextRx;
                    ry = nextRy;
                }

                //#만날 때까지 같은 방향으로 파란 구슬 이동
                while (true) {
                    int nextBx = bx + dx[i];
                    int nextBy = by + dy[i];
                    if (board[nextBx][nextBy] == '#') {
                        break;
                    }
                    if (board[nextBx][nextBy] == 'O') {
                        isBlueHole = true;
                        break;
                    }
                    bx = nextBx;
                    by = nextBy;
                }

                if (isBlueHole) {
                    continue;
                }
                if (isRedHole) {
                    return cnt + 1;
                }

                //두 구슬이 움직이지 않은 경우에는 큐에 안 넣음
                if (cur.redX == rx && cur.redY == ry && cur.blueX == bx && cur.blueY == by) {
                    continue;
                }

                //구슬이 겹치는 경우에는 원래 큐에서 꺼냈던 빨간구슬과 파란구슬 중에 어느게 뒷쪽인지 판단해서 위치를 조정
                if (rx == bx && ry == by) {
                    //오 0, 왼1, 위 2, 아래 3
                    switch (i) {
                        case 0:
                            //오른쪽으로 이동한거니까 y좌표가 큰쪽이 앞쪽, 작은쪽이 뒷쪽
                            if (cur.redY < cur.blueY) {
                                ry--;
                            } else {
                                by--;
                            }
                            break;
                        case 1:
                            //왼쪽으로 이동한거니까 y좌표 작은쪽이 앞쪽, 큰 쪽이 뒷쪽
                            if (cur.redY < cur.blueY) {
                                by++;
                            } else {
                                ry++;
                            }
                            break;
                        case 2:
                            //위로 이동은 x좌표 작은쪽이 앞, 큰 게 뒤
                            if (cur.redX < cur.blueX) {
                                bx++;
                            } else {
                                rx++;
                            }
                            break;
                        case 3:
                            //아래는 x좌표 큰 게 앞, 작은 게 뒤
                            if (cur.redX < cur.blueX) {
                                rx--;
                            } else {
                                bx--;
                            }
                            break;
                    }
                }
                q.offer(new goosle(rx, ry, bx, by, cnt + 1));
            }
        }
        return -1;
    }
}
