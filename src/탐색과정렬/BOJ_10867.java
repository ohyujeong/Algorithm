package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            if(i+1 != N && arr[i] == arr[i+1]){
                continue;
            }
            sb.append(arr[i]).append(" ");
        }


        System.out.println(sb);
    }
}
