package 프로그래머스;

import java.util.*;

//여행 경로
public class travel {

    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;


    public static void dfs(int depth, String start, String path, String[][] tickets){
        if(depth == tickets.length){
            list.add(path);
            return;
        }

        for(int i = 0; i< tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }

    }

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs(0,"ICN","ICN", tickets);

        Collections.sort(list);

        String[] answer = list.get(0).split(" ");

        return answer;
    }

    public static void main(String[] args){

        travel T = new travel();

//        String[][] test = {{"ICN","A"},{"ICN","B"},{"B","ICN"}};
        String[][] test2 ={{"ICN","COO"},{"COO","ICN"},{"COO","ICN"}};
        String[][] test = {{"ICN","BOO"}, {"ICN", "COO"}, {"COO","DOO"}, {"DOO","COO"}, {"BOO","DOO"},{"DOO","BOO"}, {"BOO","ICN"},{"COO","BOO"}};
//['ICN', 'BOO', 'DOO', 'BOO', 'ICN', 'COO', 'DOO', 'COO', 'BOO']
        //https://school.programmers.co.kr/questions/10332
        //        String[][] test = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
//        T.solution(test);
        T.solution(test2);

    }
}
