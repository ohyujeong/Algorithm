package 그래프;

import java.util.*;

//최소 환승 경로
public class SOL8_2 {

    public int solution(int[][] routes, int s, int e){

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                ArrayList<Integer> list = new ArrayList<>();
                graph.putIfAbsent(routes[i][j], list);
                graph.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        boolean[] visited = new boolean[routes.length];

        int cnt = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int tmp = q.poll();
                for(int line : graph.get(tmp)){
                    if(visited[line]) continue;
                    visited[line] = true;
                    for(int stop : routes[line]){
                        if(stop == e) return cnt;
                        q.offer(stop);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args){
        SOL8_2 T = new SOL8_2();
       System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
       System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
       System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
       System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
