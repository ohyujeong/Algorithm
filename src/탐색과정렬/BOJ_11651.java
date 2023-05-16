package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[N][2];
;

        for(int i=0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });


        for(int i=0; i<arr.length; i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }

        System.out.println(sb);
    }
}
