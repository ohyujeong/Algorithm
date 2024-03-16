package 백준;

import java.util.*;
import java.io.*;

//숫자 카드
public class boj10816 {

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            int key = Integer.parseInt(st.nextToken());
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }


        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
            if(hm.containsKey(key)){
                sb.append(hm.get(key));
                sb.append(" ");
            }
            else{
                sb.append(0);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
