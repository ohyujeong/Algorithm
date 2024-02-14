package 프로그래머스2024;


//피로도 (완전 탐색)
public class pro27 {

    public int answer = 0;
    public boolean[] visited;

//    public void dfs(int depth, int sum, int[][]dungeons, int k){
//
//        if(depth == dungeons.length){
//            answer = Math.max(answer, sum);
//            return;
//        }
//
//        for(int i=0; i<dungeons.length; i++) {
//            if (dungeons[i][0] <= k && !visited[i]) {
//                k -= dungeons[i][1];
//                visited[i] = true;
//                dfs(depth + 1, sum+1, dungeons, k);
//                visited[i] = false;
//                k+=dungeons[i][1];
//            }
//            dfs(depth+1, sum, dungeons, k);
//        }
//    }

    public int dfs(int[][]dungeons, int k, int sum){

        for(int i=0; i<dungeons.length; i++){
            if (dungeons[i][0] <= k && !visited[i]){
                k-=dungeons[i][1];
                visited[i] = true;
                dfs(dungeons,k, sum+1);
                visited[i]= false;
                k+=dungeons[i][1];
            }
        }
        return answer = Math.max(answer, sum);
    }


    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(dungeons, k,0);


        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        pro27 T = new pro27();

        int[][] test ={{9, 2}, {10, 3}, {7, 3}, {5, 4}, {1, 1}};
        T.solution(10, test);
    }
}
