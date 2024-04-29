package 다시풀기;

import java.io.*;
import java.util.*;

public class boj15686 {

    static int N,M;

    //0빈 칸, 1 집, 2 치킨집
   static int[][] map;
   static boolean[] visited;
   static ArrayList<int[]> chickenList = new ArrayList<>();

   static int min = Integer.MAX_VALUE;

   static int[] chicken;

   static void combi(int depth, int start){

       if(depth==M){
           //치킨집을 M개 조합이 완성되면 도시의 치킨거리 계산
           cntChicken();
           return;
       }

       for(int i=start; i<chickenList.size(); i++){
           if(!visited[i]){
               visited[i] = true;
               chicken[depth] = i;
               combi(depth+1, i+1);
               visited[i] = false;
           }
       }
   }

   static void cntChicken(){

       int sum = 0;

       Queue<int[]> q = new LinkedList<>();

       //치킨집과의 거리를 계산해야하는 집들을 q에 삽입
       for(int i=1; i<=N; i++){
           for(int j=1; j<=N; j++){
               if(map[i][j]==1){
                   q.offer(new int[]{i,j});
               }
           }
       }

       //모든 집과 치킨집 거리 계산
       while(!q.isEmpty()){

           int[] cur = q.poll();
           int r1 = cur[0];
           int c1 = cur[1];

           int path = Integer.MAX_VALUE;

           //각 치킨집 리스트들과 집들의 거리를 계산하고, 최솟값으로 path 갱신
           for(int i=0; i<M; i++){

               int r2 = chickenList.get(chicken[i])[0];
               int c2 = chickenList.get(chicken[i])[1];

               int diff = Math.abs(r1-r2)+Math.abs(c1-c2);
               path = Math.min(path,diff);
           }

           //모든 치킨집과의 거리계산이 끝난 후 path 치킨거리 최솟값이 저장되어 있음
           sum+=path;
       }

       //도시의 치킨 거리
       min = Math.min(sum,min);

   }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        chicken = new int[M];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    chickenList.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chickenList.size()];
        combi(0,0);

        System.out.println(min);

    }

}
