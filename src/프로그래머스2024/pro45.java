package 프로그래머스2024;

import java.util.*;

//오픈 채팅방
public class pro45 {

    public String[] solution(String[] record) {

        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();

        for(String s : record){
            String action = s.split(" ")[0];
            String userId = s.split(" ")[1];
            if(action.equals("Enter")){
                result.add(userId + "님이 들어왔습니다.");
                String name = s.split(" ")[2];
                hm.put(userId, name);
            }
            if(action.equals("Leave")){
                result.add(userId + "님이 나갔습니다.");
            }
            if(action.equals("Change")){
                String name = s.split(" ")[2];
                hm.put(userId, name);
            }
        }

        String[] answer = new String[result.size()];

        for(int i=0; i<answer.length; i++){
            String s = result.get(i);
            String userId = s.split("님")[0];
            s = s.replace(userId, hm.get(userId));
            answer[i] = s;
        }

        return answer;
    }


    public static void main(String[] args){
        pro45 T = new pro45();

        String[] test = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        T.solution(test);
    }
}
