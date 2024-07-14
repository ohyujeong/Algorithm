package 다시풀기;

import java.io.*;
import java.util.*;


//1. M개 선택할 수 있는 치킨집 경우의 수를 조합으로 구함
//2. M개 선택하면 각 집과 선택된 치킨집 들의 최소거리 구함
//3. 최소거리 다 더해서 치킨거리 구하고 최소값 계산
public class boj15686 {

    static int N,M;

    //0빈 칸, 1 집, 2 치킨집
   static boolean[] visited;

   static int min = Integer.MAX_VALUE;
   static int[] chicken;
   static ArrayList<int[]> chickenStores = new ArrayList<>();
   static ArrayList<int[]> home = new ArrayList<>();

   static void combi(int depth, int start){

       if(depth==M){
           cntDistance();
           return;
       }

       //시간초과 주의, i=0부터 돌면 불필요하게 중복으로 for문을 순회함 i+1를 start인자로 넘겨줘서 start 인덱스부터 돌도록 함
       for(int i=start; i<chickenStores.size(); i++){
           if(!visited[i]){
               visited[i]=true;
               chicken[depth]=i;
               combi(depth+1, i+1);
               visited[i]=false;
           }
       }
   }

   //치킨 거리 계산
   static void cntDistance(){

       int sum = 0;
       for (int[] choiceHome : home) {
           int diff = Integer.MAX_VALUE;
           for (int j = 0; j < M; j++) {
               int idx = chicken[j];
               int[] choiceChicken = chickenStores.get(idx);
               int cntDiff = Math.abs(choiceHome[0] - choiceChicken[0]) + Math.abs(choiceHome[1] - choiceChicken[1]);
               diff = Math.min(diff, cntDiff);
           }
           sum += diff;
       }

       min = Math.min(min, sum);

   }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //M개의 치킨집
        chicken = new int[M];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int input = Integer.parseInt(st.nextToken());
                //치킨집 좌표 ArrayList에 저장
                if(input==2){
                    chickenStores.add(new int[]{i,j});
                }
                else if(input==1){
                    home.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chickenStores.size()];
        combi(0, 0);


        System.out.println(min);

    }

}
