package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Node{
//
//    Node plus1, minus1, plus6;
//    int data;
//
//    public Node(int var){
//        data = var;
//        plus1=minus1=plus6=null;
//    }
//}


public class SOL_07_8 {

    int answer =0;
    int[] dis = {1, -1, 5};
    boolean[] visited;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e){
        visited = new boolean[10001];
        visited[s] = true;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                //방향이 -1,1,5 3개라서 방향 배열 사이즈가 3이니까 j<3 까지 for문 돌림
                //dis[0] = -1, dis[1] =1, dis[2] = 5
                for(int j=0; j<3; j++){
                    int next = x+dis[j];
                    if(next == e){
                        return L+1;
                    }
                    //visited배열 범위 벗어나면 안 되니까 next 범위 지정
                    if(next>=1 && next<=10000 && !visited[next]){
                        visited[next] = true;
                        Q.offer(next);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args){

        SOL_07_8 T = new SOL_07_8();

        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();


        System.out.println(T.BFS(S, E));
    }
}
