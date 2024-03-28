package 힙;

import java.util.*;

//국회의원 선거
public class boj1417 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int dasom = sc.nextInt();

        for(int i=1; i<n; i++){
            pQ.offer(sc.nextInt());
        }

        //후보가 다솜 한 명이면 매수할 사람이 없음으로 0 리턴하고 끝
        if(n==1){
            System.out.println(0);
            return;
        }

        int cnt = 0;
        //다솜이 얻은 표가 아직 max값이 아니면 계속해서 매수
        //가장 표가 많은 사람한테서부터 1표씩 가져오면 됨
        while(true){
            //가장 표가 많은 사람이 Q의 가장 앞에 있음->내림차순 우선순위큐
            int max = pQ.poll();
            if(dasom>max){
                break;
            }
            dasom++;
            cnt++;
            //max값에서 매수한 사람 1명 빼고 다시 q에 넣음
            pQ.offer(max-1);
        }

        System.out.println(cnt);


    }
}
