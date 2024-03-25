package 투포인터;

import java.util.*;
public class boj2003 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];

        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while(true){
            if(sum>=m){
                sum-=A[left++];
            }
            else if(right==n){
                break;
            }
            else if(sum<m){
                sum+=A[right++];
            }
            if(sum==m){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
