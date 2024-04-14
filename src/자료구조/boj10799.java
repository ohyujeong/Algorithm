package 자료구조;

import java.io.*;
import java.util.*;

//쇠막대기
public class boj10799 {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stick = br.readLine();

        int ans = 0;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<stick.length(); i++){
            char c = stick.charAt(i);
            if(c=='('){
                st.add(c);
            }
            else{
                if(stick.charAt(i-1)=='('){
                    st.pop();
                    ans+=st.size();
                }
                else{
                    st.pop();
                    ans+=1;
                }
            }
        }


        System.out.print(ans);


    }

}
