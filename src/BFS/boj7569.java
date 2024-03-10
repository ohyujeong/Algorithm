package BFS;

import java.util.*;

//토마토
public class boj7569 {

    public static Queue<int[]> q = new LinkedList<>();
    public static ArrayList<int[][]> list;

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static int M;
    public static int N;

    public static int answer = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        int H = sc.nextInt();

        list = new ArrayList<>();

        for(int i=0; i<H; i++){
            int[][] tomato = new int[N][M];
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    tomato[j][k] = sc.nextInt();
                }
            }
            list.add(tomato);
        }

        int cnt = 0;
        for(int[][] arr : list){
            if(check(arr)){
                cnt++;
            };
        }

        if(cnt==H){
            System.out.println(0);
            return;
        }

        int idx = 0;

        for(int[][] arr : list){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j]==1){
                        q.offer(new int[]{i,j,idx});
                    }
                }
            }
            idx++;
        }

        answer = bfs();

        for(int[][] arr : list){
            if(notALl(arr)){
                System.out.println(-1);
                return;
            };
        }

        System.out.println(answer);
    }


    //모두 못 익는거
    public static boolean notALl(int[][] arr){

        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
        }

        if(cnt>0){
            return true;
        }
        return false;
    }

    //이미 다 익었는지 확인, 다 익었으면 true 반환
    public static boolean check(int[][] arr){

        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
        }

        if(cnt==0){
            return true;
        }
        return false;
    }

    public static boolean upDown(int x, int y, int idx){

        int down=0;
        int up=0;

        boolean flag = false;

        if(idx>0 && idx<list.size()-1){
            down = idx-1;
            up = idx+1;

            if(list.get(down)[x][y]==0){
                list.get(down)[x][y]=1;
                flag = true;
                q.offer(new int[]{x,y,down});
            }
            if(list.get(up)[x][y]==0){
                list.get(up)[x][y]=1;
                flag = true;
                q.offer(new int[]{x,y,up});
            }
        }

        else if(idx==0 && list.size()>1){
            up = idx+1;
            if(list.get(up)[x][y]==0){
                list.get(up)[x][y]=1;
                flag = true;
                q.offer(new int[]{x,y,up});
            }
        }

        else if(idx>0 && idx==list.size()-1){
            down = idx-1;
            if(list.get(down)[x][y]==0){
                list.get(down)[x][y]=1;
                flag = true;
                q.offer(new int[]{x,y,down});
            }
        }

        return flag;
    }


    public static int bfs(){

        int L = 0;

        while(!q.isEmpty()){
            int len = q.size();

            boolean flag = false;
            boolean flag2 = false;

            for(int i=0; i<len; i++){
                int[] tmp = q.poll();

                int idx = tmp[2];
                int[][] arr = list.get(idx);
                //갔다왔다는 표시
                arr[tmp[0]][tmp[1]] = 2;

                for(int j=0; j<4; j++){
                    int nx = tmp[0]+dx[j];
                    int ny = tmp[1]+dy[j];
                    if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0){
                        arr[nx][ny] = 1;
                        flag = true;
                        q.offer(new int[]{nx,ny, idx});
                    }
                    if((upDown(tmp[0],tmp[1],idx))){
                        flag2 = true;
                    }
                }
            }
            if(flag || flag2){
                L++;
            }
        }

        return L;
    }
}
