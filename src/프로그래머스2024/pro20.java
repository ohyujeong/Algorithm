package 프로그래머스2024;

import java.util.*;

//카드 뭉치
public class pro20 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        for(String s : cards1){
            q1.offer(s);
        }

        for(String s : cards2){
            q2.offer(s);
        }


        ArrayList<String> list = new ArrayList<>();
        for(String s : goal){
            if(!q1.isEmpty() && q1.peek().equals(s)){
                list.add(q1.poll());
            }
            if(!q2.isEmpty() && q2.peek().equals(s))   {
                list.add(q2.poll());
            }
        }

        if(list.size() == goal.length){
            return "Yes";
        }

        return "No";
    }

    public static void main(String[] args){

        pro20 T = new pro20();

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(T.solution(cards1, cards2, goal));
    }
}
