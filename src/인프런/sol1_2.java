package 인프런;

import java.util.*;

//청소
public class sol1_2 {

    public int[] solution(int[][] board, int k){

        //오른쪽 -> 아래 -> 왼쪽 -> 위
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int n = board.length;

        Queue<int[]> q = new LinkedList<>();

//        q.offer(new int[]{0,0});

        int cnt =0;
        int[] answer = new int[2];

        //방향 인덱스
        int idx = 0;

        int x=0;
        int y=0;
        while (cnt<k) {
            cnt++;
            int nx = x+dx[idx];
            int ny = y+dy[idx];
            if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==1){
                idx = (idx+1)%4;
                continue;
            }
            x = nx;
            y = ny;
//                int[] tmp = q.poll();
                //현재 방향으로 이동 해봄
//                for(int i=idx; i<4; i++){
//                    int nx = tmp[0] + dx[i];
//                    int ny = tmp[1] + dy[i];
//                    if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==0){
//                        q.offer(new int[]{nx,ny});
//                    }
//                    if(!q.isEmpty()){
//                        idx=i;
//                        cnt++;
//                        break;
//                    }
//                    //방향 바꿈
//                    else{
//                        cnt++;
//                        //방향 바꾸느라 1초 썼는데 시간 끝이면 현재 위치 반환
//                        if(cnt==k){
//                            return tmp;
//                        }
//                        if(i==3){
//                            i=-1;
//                        }
//                    }
//                }
            }
//
//        answer = q.poll();

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        sol1_2  T = new sol1_2 ();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }

}
