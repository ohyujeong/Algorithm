package 투포인터;

import java.io.*;
import java.util.*;

//좋다
public class boj1253 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i=0; i<n; i++){

            int lt = 0;
            int rt = n-1;
            long target = arr[i];

            while(lt<rt){
                if(arr[lt]+arr[rt]==target){
                    //자기 자신 제외
                    if(lt!=i && rt!=i){
                        cnt++;
                        break;
                    }
                    else if(lt==i) lt++;
                    else if(rt==i) rt--;
                }
                else if(arr[lt]+arr[rt]<target) lt++;
                else rt--;
            }
        }

        System.out.println(cnt);
    }
}
