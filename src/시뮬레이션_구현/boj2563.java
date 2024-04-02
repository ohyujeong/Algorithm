package 시뮬레이션_구현;

import java.util.*;

//색종이
public class boj2563 {


    static boolean[][] arr;

    private static void fill(int x, int y){

        for(int j=x; j<x+10; j++){
            for(int i=y; i<y+10; i++){
                arr[i][j] = true;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new boolean[101][101];

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            fill(x,y);
        }

        int ans = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j]){
                    ans++;
                }
            }
        }

        System.out.println(ans);


    }

}
