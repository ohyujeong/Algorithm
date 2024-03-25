package 투포인터;

import java.util.Scanner;

//연속된 자연수의 합
public class sol5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = i+1;
        }

        int l = 0;
        int r = 0;
        int sum  = 0;
        int answer = 0;
        while(true){
            sum+=arr[r++];
            if(r-l!=0 && sum==n){
                answer++;
            }
            if(r==n){
                break;
            }
            while(sum>=n){
                sum-=arr[l++];
                if(r-l!=0 && sum==n){
                    answer++;
                }
            }
        }


        System.out.println(answer);
    }
}
