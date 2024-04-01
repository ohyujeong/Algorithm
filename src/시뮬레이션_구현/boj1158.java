package 시뮬레이션_구현;

import java.util.*;

//요세푸스 문제
public class boj1158 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            for(int i=1; i<k; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
