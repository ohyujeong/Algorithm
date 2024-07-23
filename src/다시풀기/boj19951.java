package 다시풀기;

import java.util.*;
import java.io.*;

public class boj19951 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n+2];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[a] += k;
            sum[b+1] -= k;
        }


        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            tmp += sum[i];
            sb.append(arr[i]+tmp).append(" ");
        }

        System.out.println(sb);

    }
}
