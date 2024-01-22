package BFS;


import java.util.*;

//팰린드롬 경우의 수 찾기 (인프런)
public class SOL6_4 {

    public static HashMap<Character, Integer> hm = new HashMap<>();
    public static Deque<Character> tmp = new LinkedList<>();
    public static ArrayList<String> result = new ArrayList<>();
    public static int n;

    private static void dfs(){

        if(tmp.size() == n){
            StringBuilder sb = new StringBuilder();
            for(char c : tmp){
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        for(char c : hm.keySet()){
            if(hm.get(c) == 0){
                continue;
            }
            tmp.addFirst(c);
            tmp.addLast(c);
            hm.put(c, hm.get(c)-2);
            dfs();
            tmp.removeFirst();
            tmp.removeLast();
            hm.put(c, hm.get(c)+2);
        }

    }

    public String[] solution(String s){

        n = s.length();

        //문자열 해싱
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        int oddCnt = 0;

        //홀수를 밸류로 가진 char가 2개 이상이면
        for(int i : hm.values()){
            if(i%2!=0){
                oddCnt++;
            }
        }

        String[] answer = {};

        if(oddCnt>1){
            return answer;
        }

        if(oddCnt==1){
            for(char c : hm.keySet()){
                if(hm.get(c)%2!=0){
                    tmp.add(c);
                    hm.put(c, hm.get(c)-1);
                }
            }
        }

        dfs();

        answer = new String[result.size()];

        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }


    public static void main(String[] args){
        SOL6_4 T = new SOL6_4();

        String s = "abbccee";

        T.solution(s);
    }
}
