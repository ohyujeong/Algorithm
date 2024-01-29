package BFS;

import java.util.LinkedList;
import java.util.Queue;

//인프런 it 유제 집으로 이동
public class SOL7_2 {

    public static int[][] ch;
    public static Queue<int[]> q = new LinkedList<>();


    public int solution(int[] pool, int a, int b, int home){

        ch = new int[2][100001];

        for(int i=0; i<pool.length; i++){
            ch[0][pool[i]] = 1;
            ch[1][pool[i]] = 1;
        }

        q.offer(new int[]{0,0});

        int level = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int[] tmp = q.poll();
                if(tmp[0] == home){
                    System.out.println(level);
                    return level;
                }
                int plus = tmp[0] + a;
                if(plus<=100001 && ch[0][plus] == 0){
                    q.offer(new int[]{plus,0});
                    ch[0][plus] = 1;
                }
                int back = tmp[0] - b;
                if(back>=0 && ch[1][back] == 0){
                    q.offer(new int[]{back,1});
                    ch[1][back] = 1;
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){

        SOL7_2 T = new SOL7_2();


        int[] pool = {11,7,20};
        int a =3;
        int b=2;
        int home =10;
        T.solution(pool, a, b, home);

    }
}
