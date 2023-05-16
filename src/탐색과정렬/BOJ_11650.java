package 탐색과정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Integer[][] arr = new Integer[N][2];

        StringTokenizer st;


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].equals(o2[0])){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });

        for(int i=0; i<arr.length; i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }

        System.out.println(sb);

//        for(int i=0; i<arr.length; i++){
//            bw.write(arr[i][0] + " " + arr[i][1] + '\n');
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();

    }
}
