package 자료구조;

import java.util.*;

//현관문 출입 순서
public class sol3_3 {

    public int[] solution(int[] arrival, int[] state){

        int[] answer = new int[arrival.length];

         int time = arrival[0];

         answer[0] = time;
         int cur = state[0];

         Deque<Integer> q = new LinkedList<>();
         time++;

         for(int i=1; i<arrival.length; i++){
             //도착시간이 현재 시간과 같거나 작으면 현재시간(time)에 와 있는거니까
             //state 검사해서, state같으면 현재 시간에 현관문을 이용
             //도착한 순서대로 배열을 검사하니까 빨리 도착하고&&state같은 사람이 현관문을 먼저 이용하게 됨
             if(arrival[i]<=time){
                 if(state[i]==cur){
                     answer[i] = time;
                     time++;
                 }
                 //도착했지만, 현재 state가 다를 경우 일단 q에 도착한 순서대로 삽입
                 else{
                     q.add(i);
                 }
             }
             //arrival[i]번째가 현재시간(time)보다 클 경우, time에 arrival[i]는 없음
             // q에 들어가 있는 사람들이 차례대로 현관문을 이용하게 됨
             else{
                 while(!q.isEmpty()){
                     int idx = q.poll();
                     answer[idx] = time;
                     time++;
                     cur = state[idx];
                 }
                 //증가한 time이랑 arriva[i]를 비교함
                 //q에 있는 애들이 현관문 다 이용한 후의 time보다 arrival[i]가 크면
                 //arrival[i]는 arrival[i]가 돼야 도착하니까 time을 변경
                 if(arrival[i]>time){
                     time = arrival[i];
                     answer[i] = time;
                     cur = state[i];
                     time++;
                 }
                 //증가한 time이 arrival[i]와 같거나 크면 arrival[i]는 현재 타임에 도착
                 //현관문 이용
                 else{
                     answer[i] = time;
                     time++;
                     cur = state[i];
                 }
             }
         }

         //마지막까지 순서 밀려서 남아 있는 애들 차례대로 현관문 이용
         while(!q.isEmpty()){
             answer[q.poll()] = time;
             time++;
         }


        return answer;
    }

    public static void main(String[] args){
        sol3_3 T = new sol3_3();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
       System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }


}
