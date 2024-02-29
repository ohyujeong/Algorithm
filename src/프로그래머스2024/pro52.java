package 프로그래머스2024;

import java.util.*;

//프렌즈 4블록
public class pro52 {


    char[][] map;

    public void change(int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (map[i][j] == '-') {
                    for(int k=i; k<m; k++){
                        if(map[k][j]=='-'){
                            continue;
                        }
                        map[i][j] = map[k][j];
                        map[k][j] = '-';
                        break;
                    }
                }
            }
        }
    }


    public int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];

        for(int i=0; i<m; i++){
            map[i] = board[m-i-1].toCharArray();
        }

        while(true){
            boolean flag= true;
            boolean[][] visited = new boolean[m][n];

            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){

                    if(map[i][j]=='-'){
                        continue;
                    }

                    char c = map[i][j];

                    if(map[i][j+1]==c && map[i+1][j]==c && map[i+1][j+1]==c){
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        flag =false;
                    }
                }
            }

            if(flag){
                break;
            }

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]){
                        map[i][j] = '-';
                        answer++;
                    }
                }
            }

            change(m, n);

        }

        return answer;
    }

    public static void main(String[] args){

        pro52 T =new pro52();

        System.out.println(T.solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(T.solution(6,6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));

    }
}
