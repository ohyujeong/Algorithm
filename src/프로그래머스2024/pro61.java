package 프로그래머스2024;

import java.util.*;

//게임 맵 최단거리
public class pro61 {

    public int solution(int[][] maps) {

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});

        int L =0;
        boolean flag = false;
        while(!q.isEmpty()){

            int len = q.size();

            for(int i=0; i<len; i++){
                int[] tmp = q.poll();
                maps[tmp[0]][tmp[1]] = 0;
                for(int j=0; j<4; j++){

                    int nx = tmp[0]+dx[j];
                    int ny = tmp[1]+dy[j];

                    if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1){
                        q.offer(new int[]{nx,ny});
                        maps[nx][ny] = 0;
                        if(nx==n-1 && ny==m-1){
                            flag = true;
                        }
                    }
                }
            }
            L++;
        }


        if(flag){
            return L;
        }
        else{
            return -1;
        }

    }

    public static void main(String[] args){

        pro61 T = new pro61();

        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(T.solution(arr));

    }
}
