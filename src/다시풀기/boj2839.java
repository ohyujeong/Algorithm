package 다시풀기;

import java.io.*;

public class boj2839 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        //3,5 킬로그램 봉지
        if(N%5==0){
            System.out.println(N/5);
            return;
        }
        if(N<3 || N==4){
            System.out.println(-1);
            return;
        }
        if(N == 3){
            System.out.println(1);
            return;
        }


        dp[3] = 1;
        dp[5] = 1;

        for(int i=6; i<=N; i++){
            if(i%5==0){
                dp[i]=dp[i-5]+1;
            }
            else if((i%5)%3==0){
                dp[i]=dp[i-5]+dp[3];
            }
            else if(i%3==0){
                if(dp[i]!=0){
                    dp[i] = Math.min(dp[i], dp[i-3]+1);
                }
                else{
                    dp[i] = dp[i-3]+1;
                }
            }
            else{
                for(int j=i-1; j>0; j--){
                    if(dp[j]!=0 && ((i-j)%5==0 || (i-j)%3==0)) {
                        dp[i] = dp[j]+dp[i-j];
                        break;
                    }
                }
            }
        }


        if(dp[N]!=0){
            System.out.println(dp[N]);
        }
        else{
            System.out.println(-1);
        }

    }
}
