import java.util.*;

public class BOJ_10952 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int A,B;

        while(true){
            A = sc.nextInt();
            B = sc.nextInt();

            if( A==0 && B ==0){
                sc.close();
                break;
            }
            System.out.println(A+B);
        }
    }
}
