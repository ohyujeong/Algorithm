package 탐색과정렬;

import java.util.*;
import java.io.*;

//수 찾기
public class boj1920 {

    static int n,m;

    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();
         StringTokenizer st = new StringTokenizer(br.readLine());
         for(int i=0; i<n; i++){
             hm.putIfAbsent(Integer.parseInt(st.nextToken()),1);
         }

         m = Integer.parseInt(br.readLine());

         st = new StringTokenizer(br.readLine());
         for(int i=0; i<m; i++){
             int find = Integer.parseInt(st.nextToken());
             if(hm.containsKey(find)){
                 System.out.println(1);
             }
             else{
                 System.out.println(0);
             }
         }

    }

}
