package 탐색과정렬;

import java.util.*;
import java.io.*;

//DNA 비밀번호
public class boj12891 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int[] check = new int[4];
        st = new StringTokenizer(br.readLine());

        //A,C,G,T
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        //첫 부분문자열의 알파벳들 카운팅
        int[] countAlpha = new int[4];

        for(int i=0; i<p; i++){
            switch (arr[i]){
                case 'A' : countAlpha[0]++; break;
                case 'C' : countAlpha[1]++; break;
                case 'G' : countAlpha[2]++; break;
                case 'T' : countAlpha[3]++; break;
            }
        }

        for(int i=0; i<=s-p; i++){
            boolean flag = true;
            for(int j=0; j<4; j++){
                if(countAlpha[j]<check[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
            if(i==s-p) break;

            countAlpha[checkAlpha(arr[i])]--;
            countAlpha[checkAlpha(arr[i+p])]++;
        }


        System.out.println(cnt);

    }

    static int checkAlpha(char x){
        switch (x){
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
        }
        return -1;
    }


}
