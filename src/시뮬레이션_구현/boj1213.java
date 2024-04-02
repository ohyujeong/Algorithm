package 시뮬레이션_구현;

import java.util.*;

//팰린드롬 만들기
public class boj1213 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] alpha = new int[26];
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i)-'A']++;
        }

        int mid = 0;
        int center  = 0;
        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2!=0) {
                mid++;
                center = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        if(mid>1){
            sb.append("I'm Sorry Hansoo");
        }
        else{
            for(int i=0; i<alpha.length; i++){
                for(int j=0; j<alpha[i]/2; j++){
                    sb.append((char)(i +65));
                }
            }
            result.append(sb);

            if(mid==1){
                sb.append((char)( center +65));
            }
        }

        System.out.println(sb.toString()+result.reverse());

    }
}
