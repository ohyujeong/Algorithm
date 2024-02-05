package 프로그래머스2024;


//이웃한 칸
public class pro15 {

    public int solution(String[][] board, int h, int w) {

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int answer = 0;

        String color = board[h][w];

        for(int i=0; i<4; i++){
            int nx = h+dx[i];
            int ny = w+dy[i];

            if(nx>=0 && nx<board.length && ny>=0 && ny<board.length && board[nx][ny].equals(color)){
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        pro15 T = new pro15();

        String[][] test = {{"blue", "red", "orange", "red"},{"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        T.solution(test,1,1);
    }
}
