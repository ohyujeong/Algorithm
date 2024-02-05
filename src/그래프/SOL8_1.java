package 그래프;

import java.util.*;

//인프런 최소 비행료
public class SOL8_1 {

    public int solution(int n, int[][] flights, int s, int e, int k){


        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for(int i=0; i<n; i++){
            ArrayList<int[]> list = new ArrayList<>();
            graph.put(i, list);
        }

        //출발지가 key, 목적지와 가중치가 value로 저장된 그래프
        for(int[] arr : flights){
//            ArrayList<int[]> list = new ArrayList<>();
//            graph.putIfAbsent(arr[0], list);
            int[] info = new int[]{arr[1], arr[2]};
            graph.get(arr[0]).add(info);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s,0});

        //환승 횟수 세기
        int cnt = 0;

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int len = q.size();
            for(int j=0; j<len; j++){
                int[] tmp = q.poll();
                int start = tmp[0];
                int startLen = graph.get(start).size();
                for(int i=0; i<startLen; i++){
                    int fee = tmp[1];
                    int arrival = graph.get(tmp[0]).get(i)[0];
                    fee += graph.get(start).get(i)[1];
                    q.offer(new int[]{arrival,fee});
                    if(arrival==e){
                        result.add(fee);
                    }
                }
            }
            if(cnt==k){
                break;
            }
            cnt++;
        }

        int answer = Integer.MAX_VALUE;
        if(result.size()==0){
            return -1;
        }

        for(int i=0; i<result.size(); i++){
            answer = Math.min(answer, result.get(i));
        }

        return answer;
    }

    public static void main(String[] args){
        SOL8_1 T = new SOL8_1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
