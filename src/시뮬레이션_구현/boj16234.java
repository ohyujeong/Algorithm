package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//인구이동
public class boj16234 {

    static int[][] land;
    static int N,L,R;
    static boolean[][] visited;
    static ArrayList<int[]> list; // 인구 이동 하는 노드 리스트

    static int ans = 0;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        land = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    private static int move(){

        while(true){
            boolean isMove = false;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        //인구 이동할 총 인구수
                        int sum = bfs(i,j);
                        if(list.size()>1){
                            movePeople(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) return ans;
            ans++;
        }
    }

    private static void movePeople(int sum){
        int avg = sum/list.size();
        for(int[] cur : list){
            land[cur[0]][cur[1]] = avg;
        }
    }

    private static int bfs(int x, int y){
        Queue<int[]> q= new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new int[]{x,y});
        list.add(new int[]{x,y});
        visited[x][y] = true;

        int sum = land[x][y];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]){
                    continue;
                }
                int diff = Math.abs(land[cur[0]][cur[1]]-land[nx][ny]);
                if(diff>=L && diff<=R){
                    q.offer(new int[]{nx,ny});
                    list.add(new int[]{nx,ny});
                    sum+=land[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }


}
