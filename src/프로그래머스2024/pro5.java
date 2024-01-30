package 프로그래머스2024;

import java.util.*;

//도넛과 막대 그래프
public class pro5 {

    //정점 -> key에서 나가는 간선 개수
    public static HashMap<Integer, Integer> outLine = new HashMap<>();

    //정점 -> key로 들어오는 간선 개수
    public static HashMap<Integer, Integer> inLine = new HashMap<>();

    //생성 노드, 도넛, 막대, 8자
    public static int[] answer = new int[4];


    public static ArrayList<Integer> vertexTo = new ArrayList<>();

    private int findVertex(int[][] edges){

        for (int[] ints : edges) {
            outLine.put(ints[0], outLine.getOrDefault(ints[0], 0)+1);
            inLine.put(ints[1], inLine.getOrDefault(ints[1], 0)+1);
        }

        int max = 2;

        for(int x : outLine.keySet()){
            if(!inLine.containsKey(x) && outLine.get(x)>=max){
                answer[0] = x;
                max = outLine.get(x);
            }
        }

        return answer[0];
    }

    public int[] solution(int[][] edges) {

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        //그래프
        for(int i=0; i<edges.length; i++){

            ArrayList<Integer> graph = new ArrayList<>();
            int key = edges[i][0];
            int value = edges[i][1];

            if(hm.containsKey(key)){
                hm.get(key).add(value);
            }
            else{
                graph.add(value);
                hm.put(key, graph);
            }
        }

        int center = findVertex(edges);
        int total = outLine.get(center);

        for(int i=0; i<edges.length; i++){
            if(edges[i][0] == center){
                inLine.put(edges[i][1], inLine.get(edges[i][1])-1);
            }
        }

        hm.remove(center);
        outLine.remove(center);

        for(int x : inLine.keySet()){
            if(!outLine.containsKey(x)){
                answer[2]++;
            }
            else{
                if(outLine.get(x)==2 && inLine.get(x) ==2){
                    answer[3]++;
                }
            }
        }

        answer[1] = total-(answer[2]+answer[3]);

        for(int i=0; i<4; i++){
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        pro5 T = new pro5();

 //       int[][] edges = {{2,3},{4,3},{1,1},{2,1}};
//      int[][] edges2 = {{4,11},{1,12},{8,3},{12,7},{4,2},{7,11},{4,8},{9,6},{10,11},{6,10},{3,5},{11,1},{5,3},{11,9},{3,8}};
//
//       T.solution(edges2);
        // 정답 [2, 0, 1, 1]
//        int[][] edges3 = {{2, 1}, {2, 5}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 3}, {3, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 3}};
//        T.solution(edges3);

        //정담 [2,0,3,0]

        int[][] edges4 = {{2, 1}, {1, 3}, {2, 4}, {4, 5}, {2, 6}, {6, 7}};
        T.solution(edges4);
    }
}
