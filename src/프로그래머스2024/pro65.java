package 프로그래머스2024;

//정수 삼각형
public class pro65 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = triangle[0][0];

        for(int i=2; i<=n; i++){
            for(int j=1; j<=triangle[i-1].length; j++){
                dp[i][j]=Math.max(dp[i-1][j]+triangle[i-1][j-1], dp[i-1][j-1]+triangle[i-1][j-1]);
            }
        }

        for(int i=n; i<=n; i++){
            for(int j=1; j<=n; j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
    public static void main(String[] args){

        pro65 T = new pro65();

        T.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});

    }

}
