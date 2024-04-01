package 시뮬레이션_구현;

import java.util.*;

//프린터 큐
public class boj1966 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){

            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<N; i++){
                int priority = sc.nextInt();
                q.offer(new int[]{i, priority});
                pQ.offer(priority);
            }

            int cnt = 0;
            while(true){
                int[] cur = q.peek();
                int max = pQ.peek();

                if(cur[1]!=max){
                    q.offer(q.poll());
                }
                else{
                    cnt++;
                    if(cur[0]==M){
                        System.out.println(cnt);
                        break;
                    }
                    q.poll();
                    pQ.poll();
                }
            }

        }

    }

}
