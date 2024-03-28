package 시뮬레이션_구현;


import java.util.*;
import java.io.*;

//그룹 단어 체커
public class boj1316 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        int cnt = 0;

        for(String s : arr){
            boolean flag = true;
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                char x = s.charAt(i);
                //x의 마지막 인덱스 저장
                if(hm.containsKey(x)){
                    int pre = hm.get(x);
                    //저장된 마지막인덱스(pre)와 현재 인덱스가 1차이면 연속됨
                    if(i==(pre+1)){
                        hm.put(x, i);
                    }
                    //x가 hm에 있는데 연속된 인덱스가 아니면 떨어져서 나타나는 것
                    else{
                        flag =false;
                        break;
                    }
                }
                else{
                    hm.put(x,i);
                }
            }
            if(flag){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
