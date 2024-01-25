package BFS;

import java.util.LinkedList;
import java.util.Queue;

//인프런 it 유제 타일 점프
public class SOL7_1 {

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited;
    int[] dis;

    private int BFS(int[] nums){

        int end = nums.length-1;

        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp==end){
                break;
            }
            visited[tmp] = true;
            for (int i = 0; i <= nums[tmp]; i++) {
                int n = tmp+i;
                if (n>= nums.length) break;
                if(!visited[n] && !q.contains(n)) {
                    q.offer(n);
                    dis[n] = dis[tmp]+1;
                }
            }
        }

        if(dis[end]>0){
            return dis[end];
        }
        else{
            return -1;
        }
    }

    public int solution(int[] nums){

        visited = new boolean[nums.length];
        dis = new int[nums.length];

        q.offer(0);

        int answer = BFS(nums);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        SOL7_1 T = new SOL7_1();

        int[] test2 = {2,2,1,2,1,1};
        T.solution(test2);

        int[] test3 = {1, 0, 1, 1, 3, 1, 2, 1};
        T.solution(test3);

        int[] test = {2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1};
        T.solution(test);


        int[] test5 = {1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1};
        T.solution(test5);

        int[] test4 = {1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1};
        T.solution(test4);


    }
}
