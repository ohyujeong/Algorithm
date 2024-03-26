package 인프런;

import java.util.*;

//이분검색
public class sol8 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }


        Arrays.sort(arr);

        int l = 0;
        int r = n;

        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]<target){
                l = mid+1;
            }
            else{
                r=mid;
            }
        }

        System.out.println(r+1);

    }
}
