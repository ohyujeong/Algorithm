package 탐색과정렬;

import java.util.*;
import java.io.*;
//LIS 2 이진탐색
public class boj12015 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0]=A[0];
        int max = 1;

        for(int i=1; i<N; i++){
            int key = A[i];
            if(LIS[max-1]<key){
                max++;
                LIS[max-1]=key;
            }
            else{
                int lt = 0;
                int rt = max;
                while(lt<rt){
                    int mid = (lt+rt)/2;
                    if(LIS[mid]<key){
                        lt = mid+1;
                    }
                    else{
                        rt = mid;
                    }
                }
//                int idx = lower(LIS, key);
                LIS[lt] = key;
            }
        }

        System.out.println(max);

    }

//    static int lower(int[] arr, int target){
//
//        int lt = 0;
//        int rt = arr.length;
//
//        Arrays.sort(arr);
//
//        while(lt<rt){
//            int mid = (lt+rt)/2;
//
//            if(arr[mid]<target){
//                lt = mid+1;
//
//            }
//            else {
//                rt = mid;
//            }
//        }
//
//        return lt;
//    }
}
