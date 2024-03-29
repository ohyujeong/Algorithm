package 시뮬레이션_구현;

import java.util.*;
import java.io.*;

//크로아티아 알파벳
public class boj2941 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alpha = br.readLine();

        String[] croatia = {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(croatia));

        int ans = 0;
        for(String s : list){
            if(alpha.contains(s)){
                alpha = alpha.replace(s,"0");
            }
        }

        ans+=alpha.length();
        System.out.println(ans);
    }
}
