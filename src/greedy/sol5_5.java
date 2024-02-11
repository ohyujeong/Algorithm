package greedy;

import java.lang.reflect.Array;
import java.util.*;

class Student{
    int num;
    String team;
    int attack;
    public Student(int num, String team, int attack){
        this.num = num;
        this.team = team;
        this.attack = attack;
    }
}

//전투 게임
public class sol5_5 {
    public int[] solution(String[] students){

        int n = students.length;
        int[] answer = new int[n];

        ArrayList<Student> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String team = students[i].split(" ")[0];
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            Student s = new Student(i,team,attack);
            list.add(s);
        }

        list.sort((o1, o2) -> o1.attack-o2.attack);

        //nlogn
        int total = 0;
        int j=0;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=1; i<n; i++){
            int sNum = list.get(i).num;
            String sTeam = list.get(i).team;
            for(; j<i; j++){
                String team = list.get(j).team;
                int attack = list.get(j).attack;
                hm.put(team, hm.getOrDefault(team, 0)+attack);
                total+=attack;
            }
            answer[sNum] = total-hm.getOrDefault(sTeam, 0);
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
