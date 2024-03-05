package 프로그래머스2024;

import java.util.*;

//전력망을 둘로 나누기
public class pro56 {

    HashMap<Integer, ArrayList<Integer>> hm;

    public int bfs(int n, int start){
        boolean[] visited = new boolean[n+1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int tmp = q.poll();
            visited[tmp] = true;

            for(int i=1; i<=n; i++){
                if(hm.get(tmp).size()==0){
                    break;
                }
                if(!visited[i] && hm.get(tmp).contains(i)){
                    q.offer(i);
                    cnt++;
                }
            }
        }

        //각각 cnt개와 n-cnt개의 송전탑 가짐
        return (int)Math.abs(n-(2*cnt));
    }

    public int solution(int n, int[][] wires) {

        int answer = n;
        hm = new HashMap<>();

        for(int[] edge : wires){
            hm.putIfAbsent(edge[0], new ArrayList<>());
            hm.putIfAbsent(edge[1], new ArrayList<>());
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }

        int a,b;
        for(int i=0; i<wires.length; i++){

            a = wires[i][0];
            b = wires[i][1];

            hm.get(a).remove(Integer.valueOf(b));
            hm.get(b).remove(Integer.valueOf(a));

            answer = Math.min(answer, bfs(n, a));

            hm.get(a).add(b);
            hm.get(b).add(a);
        }

        return answer;
    }


    public static void main(String[] args){
        pro56 T = new pro56();

        int n = 9;
        int[][] arr = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(T.solution(n,arr));
    }
}
