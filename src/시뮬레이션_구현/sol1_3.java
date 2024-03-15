package 시뮬레이션_구현;

//잃어버린 강아지
public class sol1_3 {
    public int solution(int[][] board){
        int answer = 0;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int x = 0;
        int y = 0;
        int petX = 0;
        int petY = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(board[i][j]==2){
                    x=i;
                    y=j;
                }
                if(board[i][j]==3){
                    petX = i;
                    petY = j;
                }
            }
        }

        int cnt = 0;
        int idx = 0;
        int dogIdx = 0;

        while(cnt<10000){

            cnt++;
            int nx = x+dx[idx];
            int ny = y+dy[idx];

            //나무나 지도 끝을 만나면 방향 90도 회전
            if(nx<0 || nx>=10 || ny<0 || ny>=10 || board[nx][ny]==1){
                idx = (idx+1)%4;
            }
            else{
                x= nx;
                y= ny;
            }

            int dogX = petX+dx[dogIdx];
            int dogY = petY+dy[dogIdx];

            if(dogX<0 || dogX>=10 || dogY<0 || dogY>=10 || board[dogX][dogY]==1){
                dogIdx = (dogIdx+1)%4;
            }
            else{
                petX = dogX;
                petY = dogY;

            }

            if(x==petX && y==petY){
                answer = cnt;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        sol1_3 T = new sol1_3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
