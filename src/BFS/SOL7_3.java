package BFS;

import java.util.LinkedList;
import java.util.Queue;

//송아지를 잡자
public class SOL7_3 {

    public int solution(int s, int e){


        //레벨 체크 0에는 짝수레벨 1에는 홀수레벨
        int[][] ch = new int[2][2000001];

        Queue<Integer> q = new LinkedList<>();

        q.offer(s);

        int L = 0;
        int cnt = 1;

        while(!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0){
                        ch[L % 2][nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e>2000000) return -1;
            if(ch[L%2][e]==1){
                return L;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        SOL7_3 T = new SOL7_3();
        T.solution(1,34567);
    }
}
