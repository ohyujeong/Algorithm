package 프로그래머스2024;

import java.util.*;

//달리기 경주
public class pro7 {

    public String[] solution(String[] players, String[] callings) {

        //이름 - 초기 등수 저장
        HashMap<String, Integer> play = new HashMap<>();

        for(int i=0; i<players.length; i++){
            play.put(players[i], i);
        }

        for(String s : callings){
            String forward = players[play.get(s)-1];
            int cur = play.get(s);
            play.put(s, cur-1);
            play.put(forward, cur);
            players[cur] = forward;
            players[cur-1] = s;
        }


        return players;
    }

    public static void main(String[] args){
        pro7 T = new pro7();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        T.solution(players, callings);

    }
}
