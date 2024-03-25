package 투포인터;

import java.util.*;
//최대 길이 연속 부분수열
public class sol6 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int lt = 0;

        int cnt = 0;
        int max = 0;

        for(int rt=0; rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>k){
                if(arr[lt]==0)cnt--;
                lt++;
            }
            max = Math.max(max, rt-lt+1);
        }
//        while(true){
//            max = Math.max(max, (rt-lt));
//            if(arr[rt]==0){
//                if(cnt==k){
//                    while(arr[lt]==1){
//                        lt++;
//                    }
//                    lt++;
//                    cnt--;
//                }
//                cnt++;
//            }
//            rt++;
//            if(rt==n){
//                break;
//            }
//        }

        System.out.println(max);
    }
}
