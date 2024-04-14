package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//뱀
public class boj3190 {

    static List<int[]> snake;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        StringTokenizer st;

        //사과 위치
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 1;
        }

        HashMap<Integer, String> changeDir = new HashMap<>();
        int L = Integer.parseInt(br.readLine());

        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            changeDir.put(x,s);
        }

        //동, 남, 서, 북
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        //뱀의 위치, 꼬리가 맨 앞, 머리가 맨 뒤
        snake = new LinkedList<>();

        int time = 0;
        int d=0;

        snake.add(new int[]{0,0});

        while(true){

            time++;
            int len = snake.size();

            int x = snake.get(len-1)[0];
            int y = snake.get(len-1)[1];

            int nx = x+dx[d];
            int ny = y+dy[d];

            if(isFinish(nx,ny)){
                break;
            }

            snake.add(new int[]{nx,ny});
            if(board[nx][ny]==1){
                board[nx][ny]=0;
            }
            else{
                snake.remove(0);
            }

            if(changeDir.containsKey(time)){
                if(changeDir.get(time).equals("D")){
                    d++;
                    if(d>3){
                        d=0;
                    }
                }
                else{
                    d--;
                    if(d<0){
                        d=3;
                    }
                }
            }
        }


        System.out.print(time);

    }


    static private boolean isFinish(int nx, int ny){
        if(nx<0 || nx>=n || ny<0 || ny>=n){
            return true;
        }

        for(int i=0; i<snake.size(); i++){
            int[] body = snake.get(i);
            if(nx==body[0] && ny==body[1]){
                return true;
            }
        }

        return false;
    }
}
