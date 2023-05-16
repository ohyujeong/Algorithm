package 탐색과정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];

        for(int i=0; i<N; i++){
            str[i] = br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() - o2.length() == 0){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i< N; i++){
            if( i+1 != N){
                if(str[i].equals(str[i+1])){
                    continue;
                }
            }
            bw.write(str[i] + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
