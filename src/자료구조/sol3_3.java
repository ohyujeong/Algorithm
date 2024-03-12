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
             if(arrival[i]<=time){
                 if(state[i]==cur){
                     answer[i] = time;
                     time++;
                 }
                 else{
                     q.add(i);
                 }
             }
             else{
                 while(!q.isEmpty()){
                     int idx = q.poll();
                     answer[idx] = time;
                     time++;
                     cur = state[idx];
                 }
                 if(arrival[i]>time){
                     time = arrival[i];
                     answer[i] = time;
                     cur = state[i];
                     time++;
                 }
                 else{
                     answer[i] = time;
                     time++;
                     cur = state[i];
                 }
             }
         }

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
