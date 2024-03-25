package 투포인터;

import java.util.*;

public class sol3 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int max = 0;
        for(int i=0; i<k; i++){
            max+=arr[i];
        }

        int l = 0;
        int cur = max;

        while(true){
            cur-=arr[l++];
            cur+=arr[k++];
            max = Math.max(max,cur);
            if(k==n){
                break;
            }
        }

        System.out.println(max);

    }
}
