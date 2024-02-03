package 프로그래머스2024;

import java.util.*;

//신고 결과 받기
public class pro12 {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        //이용자 -> 신고 당한 횟수
        HashMap<String, Integer> reportCnt = new HashMap<>();

        //이용자 -> {신고 한 사람1, 신고 한 사람2} 리스트
        HashMap<String, ArrayList<String>> reportList = new HashMap<>();

        for(String s : id_list){
            reportCnt.put(s, 0);
            ArrayList<String> list = new ArrayList<>();
            reportList.put(s, list);
        }

        for(String s : report){

            //이용자 user1
            String user1 = s.split(" ")[0];
            //신고 당한 사람 user2
            String user2 = s.split(" ")[1];

            if(reportList.get(user1).contains(user2)){
                continue;
            }
            else{
                reportList.get(user1).add(user2);
                reportCnt.put(user2, reportCnt.get(user2)+1);
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        for(String s : id_list){
            result.put(s,0);
        }
        for(String s : reportList.keySet()){
            for(int i=0; i<reportList.get(s).size(); i++){
                String user = reportList.get(s).get(i);
                if(reportCnt.get(user)>=k){
                    result.put(s, result.get(s)+1);
                }
            }
        }

        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(id_list[i]);
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args){

        pro12 T = new pro12();

        //[1,1,2,1]
        String[] test1 = {"a", "b", "c", "d"};
        String[] test2 = {"a b", "a b", "c a", "d a", "a b", "c d", "a d", "b c", "b a", "d a"};
        T.solution(test1, test2, 2);


////        String[] test3 = {"con", "ryan"};
////        String[] test4 = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        T.solution(test3, test4, 3);
    }
}
