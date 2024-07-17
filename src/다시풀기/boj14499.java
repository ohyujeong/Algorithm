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

    //동,서,북(윗면),남(바닥면),앞,뒤
    static int[] dice = new int[6];

    // 1. 동쪽 east->south, west->north, north->east, south->west, front, back
    // 0은 2값으로 바뀌고, 1은 3값으로 바뀌고 2는 1값 3은 0값

    // 2. 서쪽 east->north, west->south, north->west, south->east, front, back
    // 3. 북쪽 east, west, north->back, south->front, front->north, back->south
    // 4. 남쪽 east, west, north->front, south->back, front->south, back->north

    // 각 방향에 따른 주사위 면의 인덱스 변화
    static int[][] dirChanges = {
            {2, 3, 1, 0, 4, 5}, // 동쪽
            {3, 2, 0, 1, 4, 5}, // 서쪽
            {0, 1, 4, 5, 3, 2}, // 북쪽
            {0, 1, 5, 4, 2, 3}  // 남쪽
    };


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

        q.offer(new int[]{x,y});
        bfs();

    }

    static void bfs(){

        int[] cur = q.poll();

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
            int[] temp = dice.clone();

            for(int i=0; i<6; i++){
                int changeIdx = dirChanges[dir][i];
                dice[i] = temp[changeIdx];
            }

            if(mapNum==0){
                map[nx][ny]=dice[3];
            }
            else{
                dice[3] = mapNum;
                map[nx][ny]=0;
            }

            //주사위 새 좌표
            q.offer(new int[]{nx,ny});
            //윗 면 출력
            System.out.println(dice[2]);
        }

    }


}
