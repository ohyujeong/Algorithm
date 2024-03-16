package 백준;

import java.util.*;
import java.io.*;

//숫자 카드
public class boj10816 {

    static int n,m;
    static int[] arr, check;

    static int upper(int left, int right, int target){

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid] <= target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }


    static int lower(int left, int right, int target){

        while(left<right){
            int mid = (left+right)/2;

            if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }

        return right;
    }

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        check = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] answer = new int[m];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            int target = check[i];

            int low = lower(0, n, target);
            int up = upper(0, n, target);

            answer[i] = up-low;
            sb.append(answer[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
