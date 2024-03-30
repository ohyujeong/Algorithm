package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//덩치
public class boj7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int rank = 1;;
            int kg = arr[i][0];
            int height = arr[i][1];
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(kg<arr[j][0] && height<arr[j][1]){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }

}

