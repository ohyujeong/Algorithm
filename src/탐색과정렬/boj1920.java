package 탐색과정렬;

import java.util.*;
import java.io.*;

//수 찾기
public class boj1920 {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

         arr = new int[n];

         StringTokenizer st = new StringTokenizer(br.readLine());
         for(int i=0; i<n; i++){
             arr[i] = Integer.parseInt(st.nextToken());
         }

         m = Integer.parseInt(br.readLine());

         int[] find = new int[m];

         st = new StringTokenizer(br.readLine());
         for(int i=0; i<m; i++){
             find[i] = Integer.parseInt(st.nextToken());
         }

         Arrays.sort(arr);

         for(int i=0; i<m; i++){
             boolean flag = binarySearch(0,n,find[i]);
             if(flag){
                 System.out.println(1);
             }
             else{
                 System.out.println(0);
             }
         }


    }

    static boolean binarySearch(int lt, int rt, int target){

        while(lt<rt){
            int mid = (lt+rt)/2;
            if(arr[mid]<target){
                lt=mid+1;
            }
            else if(arr[mid]>target){
                rt=mid;
            }
            else if(arr[mid]==target){
                return true;
            }
        }

        return false;

    }
}
