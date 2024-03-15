package 시뮬레이션_구현;

import java.util.*;

//좌석 번호
public class sol1_4 {

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        if(k>c*r){
            return answer;
        }

        int[] dx={-1, 0, 1, 0};
        int[] dy={0, 1, 0, -1};

        int cnt = 1;

        int x = r-1;
        int y = 0;

        int idx = 0;

        boolean[][] visited = new boolean[r][c];
        visited[x][y] = true;

        while(cnt<k){

            int nx = x+dx[idx];
            int ny = y+dy[idx];

            if(nx<0 || nx>=r || ny<0 || ny>=c || visited[nx][ny]){
                idx = (idx+1)%4;
                continue;
            }

            x = nx;
            y = ny;
            visited[x][y] = true;
            cnt++;
        }

        answer[0] = y+1;
        answer[1] = r-x;
        return answer;
    }

    public static void main(String[] args){
        sol1_4 T = new sol1_4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }

}
