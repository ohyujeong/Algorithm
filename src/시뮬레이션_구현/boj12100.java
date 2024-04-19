package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

public class boj12100 {

    static int N;
    static int[][] board;
    static int max = 0;

    static void dfs(int depth){
        if(depth==5){
            findMax();
            return;
        }

        //board 초기값 백업할 origin 배열 생성
        int[][] origin = new int[N][N];
        for(int i=0; i<N; i++){
            origin[i] = board[i].clone();
        }

        for(int i=0; i<4; i++){
            move(i);
            dfs(depth+1);

            //i번째 방향으로 탐색 끝나면 변경된 board 값 원상복귀해줌
            //같은 depth에 다른 방향으로도 탐색해봐야 함으로
            for(int j=0; j<N; j++){
                board[j] = origin[j].clone();
            }

        }
    }

    public static void findMax() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                max = Math.max(max, board[i][j]);
    }

    static void move(int dir){

        //상, 하, 좌, 우
        switch (dir){
            case 0 :
                for(int i = 0; i < N; i++) {
                    //값을 옮길 위치
                    int index = 0;

                    //블럭의 값 처음에는 0
                    int block = 0;
                    for(int j = 0; j < N; j++) {

                        //board[j][i] -> 위로 옮겨주니까 같은 열에서 행(j)을 증가시켜야함
                        //0이 아니어야 옮길 값이 있음..
                        if(board[j][i] != 0) {
                            //block은 board[j][i]윗 칸에 있는 값이 됨!!
                            //같으면 합칠 수 있음
                            if(block == board[j][i]) {
                                //위로 옮기는거니까 index-1
                                board[index - 1][i] = block * 2;

                                //한 번 이동에 한 번만 합칠 수 있음으로 block = 0으로 다시 초기화
                                block = 0;

                                //j,i번째 값 위로 옮겨졌으니까 0
                                board[j][i] = 0;
                            }
                            else {
                                //board[j][i]값을 옮긴거니까 block 값은 board[j][i]가 됨..
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

    }
}
