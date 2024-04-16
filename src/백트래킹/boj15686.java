package 백트래킹;

import java.util.*;
import java.io.*;

//치킨 배달
public class boj15686 {

    static int N,M;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    static int[] homeArr;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    home.add(new int[]{i,j});
                }
                if(map[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0,0);

        System.out.println(ans);

    }

    static void dfs(int start, int depth){
        if(depth==M){
            chickenDistance();
            return;
        }

        for(int i=start; i<chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void chickenDistance(){

        for(int i=0; i<visited.length; i++){
            if(visited[i]){
                q.offer(chicken.get(i));
            }
        }

        homeArr = new int[home.size()];
        Arrays.fill(homeArr, 999);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<home.size(); i++){
                int r = home.get(i)[0];
                int c = home.get(i)[1];
                int dis = Math.abs(x-r)+Math.abs(y-c);
                homeArr[i]= Math.min(homeArr[i],dis);
            }
        }

        int total = 0;
        for(int i=0; i<homeArr.length; i++){
            total+=homeArr[i];
        }

        ans = Math.min(ans, total);
    }



}
