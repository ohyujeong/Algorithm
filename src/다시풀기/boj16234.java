package 다시풀기;

import java.util.*;
import java.io.*;

//인구 이동
public class boj16234 {

    static int N,L,R;
    static int[][] map;
    static int answer = 0;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    static boolean cntPeopleGap(){

        Queue<int[]> q = new LinkedList<>();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        int graphNum = 0;

        boolean flag = false;

        //map 완전탐색 하면서 인접하게 이동할 수 있는 칸들 좌표를 graph에 저장
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(!visited[i][j]){

                    graph.add(new ArrayList<>());
                    graph.get(graphNum).add(new int[]{i,j});

                    q.offer(new int[]{i,j});
                    visited[i][j] = true;

                    // 이동할 수 있는 연합이 같은 graph에 저장됨
                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = cur[0]+dx[k];
                            int ny = cur[1]+dy[k];

                            if(nx<0 || ny<0 || nx>=N || ny>=N|| visited[nx][ny]){
                                continue;
                            }

                            int gap = Math.abs((map[cur[0]][cur[1]])-map[nx][ny]);
                            if(gap>=L && gap<=R){
                                flag = true;
                                visited[nx][ny] = true;
                                graph.get(graphNum).add(new int[]{nx,ny});
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }

                    graphNum++;

                }
            }
        }


        //인구 수 차이가 L이사, R이하여서 국경선 오픈된 곳 있으면 인구이동
        if(flag){
            movePeople(graph);
            answer++;
        }

        return flag;
    }


    static void movePeople(ArrayList<ArrayList<int[]>> graph){

        int totalPeople=0;
        int cntNation = 0;

        for(int i=0; i<graph.size(); i++){
            cntNation+=graph.get(i).size();
            for(int j=0; j<graph.get(i).size(); j++){
                int[] cur = graph.get(i).get(j);
                totalPeople+=map[cur[0]][cur[1]];
            }
            int cntPeople = (totalPeople)/(cntNation);

            for(int j=0; j<graph.get(i).size(); j++){
                int[] cur = graph.get(i).get(j);
                map[cur[0]][cur[1]]=cntPeople;
            }

            totalPeople = 0;
            cntNation = 0;
        }
    }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            boolean flag = cntPeopleGap();
            if(!flag){
                break;
            }
        }

        System.out.println(answer);

    }

}
