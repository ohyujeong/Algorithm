package 투포인터;

import java.util.*;

//공통원소구하기
public class sol2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] B = new int[m];

        for(int i=0; i<m; i++){
            B[i] = sc.nextInt();
        }

        int p1 = 0;
        int p2 = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();

        while(p1<n && p2<m){
            if(A[p1]<B[p2]){
                p1++;
            }
            else if(A[p1]>B[p2]){
                p2++;
            }
            else if(A[p1]==B[p2]){
                sb.append(A[p1]).append(" ");
                p1++;
                p2++;
            }
        }

        while(p1<n){
            if(A[p1]==B[p2-1]){
                sb.append(A[p1]).append(" ");
            }
            p1++;
        }

        while(p2<m){
            if(A[p1-1]==B[p2]){
                sb.append(B[p2]).append(" ");
            }
            p2++;
        }


        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
