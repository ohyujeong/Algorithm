package 다시풀기;

import java.util.*;
import java.io.*;

public class boj14499 {

    static int n,m,x,y,k;
    static int[][] map;

    //1동,2서,3북,4남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Integer> con = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();

    static class Dice{
        int east;
        int west;
        int north;
        int south;
        int front;
        int back;
        public Dice(int east, int west, int north, int south, int front, int back){
            this.east =east;
            this.west =west;
            this.north = north;
            this.south = south;
            this.front = front;
            this.back = back;
        }
    }

    static Dice dice;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            con.offer(Integer.parseInt(st.nextToken()));
        }

        dice = new Dice(0,0,0,0,0,0);
        q.offer(new int[]{x,y});
        bfs();

    }

    static void bfs(){

        int[] cur = q.poll();


        //동,서,북(윗면),남(바닥면),앞면,뒷면
        int[] diceNums = new int[6];

        while(!con.isEmpty()){
            //굴리는 방향
            int dir = con.poll()-1;

            if(!q.isEmpty()){
                cur = q.poll();
            }

            int nx = cur[0]+dx[dir];
            int ny = cur[1]+dy[dir];

            if(nx<0 || ny<0 || nx>=n || ny>=m){
                continue;
            }

            //주사위가 이동한 칸의 숫자
            int mapNum = map[nx][ny];

            //굴렸으면 주사위 값 배열을 바꿔줌
            // 1. 동쪽 east->south, west->north, north->east, south->west, front, back
            // 2. 서쪽 east->north, west->south, north->west, south->east, front, back

            //윗면이 앞면값이 되고,, 뒷면이 바닥면이 됨
            // 3. 북쪽 east, west, north->back, south->front, front->north, back->south

            // 4. 남쪽 east, west, north->front, south->back, front->south, back->north
            switch (dir){
                case 0 :
                    diceNums[0]=dice.north;
                    diceNums[1]=dice.south;
                    diceNums[2]=dice.west;
                    diceNums[3]=dice.east;
                    break;
                case 1:
                    diceNums[0]=dice.south;
                    diceNums[1]=dice.north;
                    diceNums[2]=dice.east;
                    diceNums[3]=dice.west;
                    break;
                case 2:
                    //윗면, 바닥면, 앞면, 뒷면
                    diceNums[2]=dice.front;
                    diceNums[3]=dice.back;
                    diceNums[4]=dice.south;
                    diceNums[5]=dice.north;
                    break;
                case 3:
                    diceNums[2]=dice.back;
                    diceNums[3]=dice.front;
                    diceNums[4]=dice.north;
                    diceNums[5]=dice.south;
                    break;
            }

            dice.east = diceNums[0];
            dice.west = diceNums[1];
            dice.north = diceNums[2];
            dice.south = diceNums[3];
            dice.front = diceNums[4];
            dice.back = diceNums[5];

            if(mapNum==0){
                map[nx][ny]=dice.south;
            }
            else{
                dice.south = mapNum;
                diceNums[3] = mapNum;
                map[nx][ny]=0;
            }

            //주사위 새 좌표
            q.offer(new int[]{nx,ny});
            //윗 면 출력
            System.out.println(dice.north);
        }

    }


}
