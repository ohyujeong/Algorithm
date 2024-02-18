package 프로그래머스2024;

import java.util.*;

//숫자 변환하기
public class pro32 {


    public int solution(int x, int y, int n) {


        HashMap<Integer, Integer> hm = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        int L = 0;

        if(x==y){
            return 0;

        }

        while(!q.isEmpty()){
            int len = q.size();
            L++;
            for(int i=0; i<len; i++){
                int tmp = q.poll();
                int[] arr = {n, tmp, tmp*2};
                for(int j=0; j<3; j++){
                    int nx = tmp+arr[j];
                    if(nx==y){
                        return L;
                    }
                    if(nx>y){
                        break;
                    }
                    if(!hm.containsKey(nx)){
                        q.offer(nx);
                        hm.put(nx, 1);
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args){
        pro32 T = new pro32();

        System.out.println(T.solution(2,5,4));
    }
}
