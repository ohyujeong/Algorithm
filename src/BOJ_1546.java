import java.util.*;

public class BOJ_1546  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        
        int[] score = new int[n];

        for(int i=0; i<n; i++){
            score[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;

        for(int i=0; i<n; i++){
            if(score[i]> max){
                max = score[i];
            }
            sum += score[i];
        }

        System.out.println((double) sum * 100/max/n);
    }
}
