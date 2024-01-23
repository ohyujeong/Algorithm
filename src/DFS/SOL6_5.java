package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//인프런 대기업유제 섹션6-5 IP 주소
public class SOL6_5 {


    public static ArrayList<String> result;
    public static LinkedList<String> tmp;

    //sArr에서 0~255까지를 만들 수 있는 경우의 수 찾는 함수
    public void dfs(int start, String s){

        if(start == s.length() && tmp.size()==4){
            String ip ="";
            for(String x : tmp){
                ip += x+".";
            }
            result.add(ip.substring(0, ip.length()-1));
        }

        for(int i = start; i<s.length(); i++){

            //첫째 자리 이외에는 0이 맨 앞으로 올 수가 없음. 02 < 이런식으로 되니까
            //첫째자리는 0. ~~ 이렇게 가능
            if(s.charAt(start) == '0' && i>start){
                return;
            }
            String num = s.substring(start, i+1);
            if(Integer.parseInt(num) > 255) return;
            tmp.add(num);
            dfs(i+1, s);
            tmp.pollLast();
        }
    }

    public String[] solution(String s){

        String[] answer = {};
        result = new ArrayList<>();
        tmp = new LinkedList<>();

        dfs(0, s);

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }

        return answer;
    }

    public static void main(String[] args){

        SOL6_5 T = new SOL6_5();

        T.solution("2025505");

    }
}
