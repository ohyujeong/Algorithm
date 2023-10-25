package DFS;

import java.util.*;

//섬나라 아일랜드
public class SOL8_13 {

    static int n;
    static int answer=0;
    static int[][] map;
    static boolean[][] visited;
    static int dirY[] = {1,0,-1,0,-1,1,1,-1};
    static int dirX[] = {0,1,0,-1,1,-1,1,-1};


    public static void dfs(int y, int x) {

        visited[y][x] = true;
        map[y][x] = 0;

        for(int i=0; i<8; i++){
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if(newY>=0 && newY<n && newX>=0 && newX<n &&!visited[newY][newX] && map[newY][newX] ==1){
                dfs(newY,newX);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[j][i] == 1){
                    dfs(j,i);
                    answer++;
                }
            }
            //한 번 탐색하면 i와 관련된 노드는 모두 true가 됨 얘네가 하나의 덩어리니까 +1해주기..
        }

        System.out.println(answer);
    }
}
