package 프로그래머스2024;

import java.util.*;
//등산 코스 정하기
public class pro66 {

    static List<List<Node>> graph;

    static private class Node{
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
     }
    }

    public boolean isGate(int v, int[] gates){
        for (int gate : gates) {
            if (v == gate) return true;
        }
        return false;
    }
    public boolean isSummit(int v, int[] summits){
        for (int summit : summits) {
            if (v == summit) return true;
        }

        return false;
    }


    public int[] dijkstra(int n, int[] gates, int[] summits){
        int[] intensity = new int[n+1];
        Queue<Node> q = new LinkedList<>();

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for(int gate : gates){
            q.add(new Node(gate, 0));
            intensity[gate] = 0; //출입구
        }

        while(!q.isEmpty()){
            Node nn = q.poll();

            if(intensity[nn.v] < nn.cost){
                continue;
            }

            //intensity 갱신
            for(int i=0; i<graph.get(nn.v).size(); i++){
                Node u = graph.get(nn.v).get(i);

                //최솟값 갱신
                int c = Math.max(intensity[nn.v], u.cost);
                if(intensity[u.v] > c){
                    intensity[u.v] = c;
                    q.add(new Node(u.v, c));
                }
            }
        }

        int sv = 0;
        int smin = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < smin) {
                smin = intensity[summit];
                sv = summit;
            }
        }

        int[] ans = {sv, smin};
        return ans;
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];


        graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] path: paths){
            int s = path[0];
            int e = path[1];
            int cost = path[2];

            if(isGate(s, gates) || isSummit(e, summits)){
                graph.get(s).add(new Node(e, cost));
            }
            else if(isGate(e, gates) || isSummit(s, summits)){
                graph.get(e).add(new Node(s, cost));
            }
            else{
                graph.get(s).add(new Node(e, cost));
                graph.get(e).add(new Node(s, cost));
            }
        }

        answer = dijkstra(n, gates, summits);

        return answer;
    }


    public static void main(String[] args){
        pro66 T = new pro66();

        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1,3};
        int[] summits = {5};
        T.solution(n, paths, gates, summits);
    }
}
