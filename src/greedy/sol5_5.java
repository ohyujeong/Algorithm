package greedy;

import java.util.*;

class Student{
    String team;
    int attack;
    public Student(String team, int attack){
        this.team = team;
        this.attack = attack;
    }
}

//전투 게임
public class sol5_5 {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        HashMap<Integer, Student> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            String team = students[i].split(" ")[0];
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            hm.put(i, new Student(team, attack));
        }

        for(int i=0; i<n; i++){
            String team = students[i].split(" ")[0];
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            for(int x : hm.keySet()){
                if(!hm.get(x).team.equals(team) && hm.get(x).attack<attack){
                    answer[i] += hm.get(x).attack;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        sol5_5 T = new sol5_5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
