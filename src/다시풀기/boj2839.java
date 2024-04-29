package 다시풀기;

import java.io.*;

public class boj2839 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N>0){
            //5KG을 최대한으로 씀
            if(N%5==0){
                cnt+=N/5;
                System.out.println(cnt);
                return;
            }
            //5로 나누어 안 떨어지면 3Kg 봉지 하나 써줌
            N-=3;
            cnt++;
        }

        if(N<0){
            System.out.println(-1);
        }
        else{
            System.out.println(cnt);
        }

    }
}
