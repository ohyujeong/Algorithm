package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//제로
public class boj10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                st.add(num);
            }
            else{
                st.pop();
            }
        }

        while(!st.isEmpty()){
            ans+=st.pop();
        }

        System.out.println(ans);


    }
}
