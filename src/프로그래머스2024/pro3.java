package 프로그래머스2024;


import java.util.LinkedList;
import java.util.Queue;


//네트워크
public class pro3 {

    public static int answer = 0;
    public static boolean[] visited;

    Queue<Integer> q = new LinkedList<>();

    private void bfs(int index, int[][] computers, int n){

       visited[index] = true;

       while(!q.isEmpty()){
           int tmp = q.poll();
           for(int i=0; i<n; i++){
               if(computers[tmp][i] == 1){
                   q.offer(i);
                   computers[tmp][i] = 0;
                   visited[i] = true;
               }
           }
       }
   }

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];

        //시작점이 정해진게 아니니까 고정호출이 아니라 방문하지 않은 인덱스에 대해 i로 호출
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                q.offer(i);
                bfs(i, computers, n);
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){

        pro3 T = new pro3();

        int[][] arr = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        T.solution(4, arr);

//        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
//        T.solution(3, arr);

//        int[][] arr2 = {{1,1,0},{1,1,1},{0,1,1}};
//        T.solution(3, arr2);
    }
}
