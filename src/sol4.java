import java.util.ArrayList;
import java.util.Scanner;

public class sol4 {

    public static ArrayList<String> solution(String[] arr){

        ArrayList<String> answer = new ArrayList<>();

        for(String x:arr){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            String str = sc.next();
            arr[i] = str;
        }
        for(String x: sol4.solution(arr)){
            System.out.println(x);
        }
    }
}
