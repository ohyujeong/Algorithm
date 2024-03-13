package 백트래킹;

import java.util.*;

//스타트와 링크
public class boj14889 {

    public static int[][] arr;
    public static boolean[] visited;
    public static boolean[] check;
    public static int answer = Integer.MAX_VALUE;
    public static int N = 0;

    public static ArrayList<Integer> team1;
    public static ArrayList<Integer> team2;
    public static int score1 = 0;
    public static int score2 = 0;

    public static void combi2(int depth, int[] out1, int[] out2, int start){

        if(depth==2){
            int i = out1[0];
            int j = out1[1];
            score1+= (arr[i][j] + arr[j][i]);

            int x = out2[0];
            int y = out2[1];
            score2+= (arr[x][y] + arr[y][x]);
            return;
        }

        for(int i=start; i<N/2; i++){
            if(!check[i]){
                check[i] = true;
                out1[depth] = team1.get(i);
                out2[depth] = team2.get(i);
                combi2(depth+1, out1, out2, i+1);
                check[i] =false;
            }
        }
    }

    public static void getTeam(){


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
        combi2(0, new int[2], new int[2], 0);
        answer = Math.min(answer, Math.abs(score1-score2));

    }

    public static void combi(int depth, int start){

        if(depth==N/2){
            getTeam();
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(depth+1, i+1);
                visited[i] = false;
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

        combi(0,0);

        System.out.println(answer);
    }
}
