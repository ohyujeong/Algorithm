package 백트래킹;

import java.util.*;

//스타트와 링크
public class boj14889 {

    public static int[][] arr;
    public static boolean[] visited;
    public static boolean[] check;
    public static int answer = Integer.MAX_VALUE;
    public static int N;

    public static ArrayList<Integer> team1;
    public static ArrayList<Integer> team2;
    public static int score1;
    public static int score2;

    //각 팀에서 2명씩 뽑는 조합
    static void score(int start, int depth, int[] out1, int[] out2){

        if(depth==2){

            int i = out1[0];
            int j = out1[1];

            int x = out2[0];
            int y = out2[1];

            score1+=(arr[i][j]+arr[j][i]);
            score2+=(arr[x][y]+arr[y][x]);

            return;
        }

        for(int i=start; i<N/2; i++){
            if(!check[i]){
                check[i] = true;
                out1[depth] = team1.get(i);
                out2[depth] = team2.get(i);
                score(i+1,depth+1, out1, out2);
                check[i]= false;
            }
        }

    }


    static void getTeam(){

        team1 = new ArrayList<>();
        team2 = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(visited[i]){
                team1.add(i);
            }
            else{
                team2.add(i);
            }
        }

        score1=0;
        score2=0;
        score(0,0, new int[2], new int[2]);
        answer=Math.min(answer, Math.abs(score1-score2));

    }

    //스타트 팀원, 링크 팀원을 뽑는 조함
    static void teamCombi(int start, int depth){

        if(depth==N/2){
            getTeam();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                teamCombi(i+1, depth+1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        visited = new boolean[N];
        check = new boolean[N/2];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] =sc.nextInt();
            }
        }

        teamCombi(0,0);

        System.out.println(answer);
    }
}
