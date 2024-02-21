package 프로그래머스2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//거리두기 확인하기
public class pro38 {

    public Queue<int[]> q;
    public int[] answer;
    public int[] dx = {1,0,-1,0};
    public int[] dy = {0,1,0,-1};


    public void bfs(String[] wait, int idx){

        while(!q.isEmpty()){

            int len = q.size();
            for(int i=0; i<len; i++){
                int[] tmp = q.poll();

                for(int j=0; j<4; j++){

                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];

                    if(nx>=0 && nx<5 && ny>=0 && ny<5 && wait[nx].charAt(ny)=='P'){
                        if(wait[tmp[0]].charAt(tmp[1])=='P'){
                            answer[idx] = 0;
                            break;
                        }
                        else{
                            q.offer(new int[]{nx,ny});
                        }
                    }
                    if(q.size()>=2){
                        answer[idx] = 0;
                        break;
                    }
                }
            }
        }
    }

    public int[] solution(String[][] places) {

        answer = new int[5];
        Arrays.fill(answer, 1);

        q = new LinkedList<>();

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(places[i][j].charAt(k)=='P'){
                        q.offer(new int[]{j,k});
                        bfs(places[i], i);
                    }
                    if(places[i][j].charAt(k)=='O'){
                        q.offer(new int[]{j,k});
                        bfs(places[i], i);
                    }
                }
            }
        }



        for(int i=0; i<5; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args){


        pro38 T = new pro38();

        String[][] test = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        T.solution(test);
    }
}
