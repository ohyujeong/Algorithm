package 프로그래머스2024;


import java.util.LinkedList;
import java.util.Queue;


//네트워크
public class pro3 {

    static boolean[] visited;
    static int answer =0;

    public void dfs(int i, int[][] computers, int n){

        visited[i] = true;

        for(int j=0; j<n; j++){
            if(!visited[j] && computers[i][j] ==1){
                dfs(j, computers, n);
            }
        }


    }

    public int solution(int n, int[][] computers){

        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers, n);
            }
        }

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
