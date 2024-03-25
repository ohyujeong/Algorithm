package 투포인터;

import java.util.Scanner;

//두 배열 합치기
public class sol1 {

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


        int startA = 0;
        int startB = 0;

        StringBuilder sb = new StringBuilder();

        while(startA<n && startB<m){
            if(A[startA]<B[startB]){
                sb.append(A[startA]).append(" ");
                startA++;
            }
            else{
                sb.append(B[startB]).append(" ");
                startB++;
            }
        }

        for(int i=startA; i<n; i++){
            sb.append(A[i]).append(" ");
        }

        for(int i=startB; i<m; i++){
            sb.append(B[i]).append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
