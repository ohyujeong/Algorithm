package DP;

import java.util.*;

public class boj15989 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[][] dy = new int[100001][4];

        dy[1][1] = 1;

        //1+1, 2
        dy[2][1] = 1;
        dy[2][2] = 1;

        //(1+1+1), (1+2), (3)
        dy[3][1] = 1;
        dy[3][2] = 1;
        dy[3][3] = 1;

        //i번째 수를 1,2,3으로 나타낼 수 있는 경우의 수
        //중복제거하기 위해 마지막 수(1,2,3) 보다 이상인 수만 더해줌
        for(int i=4; i<100001; i++){
            dy[i][1] = dy[i-1][1];
            dy[i][2] = dy[i-2][1]+dy[i-2][2];
            dy[i][3] = dy[i-3][1]+dy[i-3][2]+dy[i-3][3];
        }

        while(T-->0){
            int n = sc.nextInt();
            System.out.println(dy[n][1] + dy[n][2] + dy[n][3]);
        }
    }
}
