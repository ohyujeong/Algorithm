package 투포인터;

import java.util.Scanner;

//연속 부분수열
public class sol4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int l =0;
        int r =0;
        int sum = 0;

        int answer = 0;

        while(true){
            if(sum<m){
                sum+=arr[r++];
            }
            else{
                sum-=arr[l++];
            }
            if(sum==m){
                answer++;
            }
            if(r==n){
                break;
            }
        }

        System.out.println(answer);
    }
}
