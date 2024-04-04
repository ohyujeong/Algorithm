package 시뮬레이션_구현;

import java.util.*;

public class boj1475 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char x : s.toCharArray()){
            if(x-'0'==6 || x-'0'==9){
                char tmp = '6';
                hm.put(tmp, hm.getOrDefault(tmp, 0)+1);
                continue;
            }
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }

        int max = 0;
        for(char x : hm.keySet()){
            if(x=='6'){
                if(hm.get(x)%2==0){
                    max = Math.max(max,hm.get(x)/2);
                }
                else{
                    max = Math.max(max, (hm.get(x)/2)+1);
                }
                continue;
            }
            max = Math.max(max, hm.get(x));
        }

        System.out.println(max);
    }

}
