import java.util.*;

public class BOJ_10953 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            String str = sc.next();
            StringTokenizer st = new StringTokenizer(str, ",");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(A+B);
        }
        sc.close();
    }
}
