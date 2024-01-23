package 프로그래머스2024;

//타겟 넘버
public class pro2 {

    public static int answer = 0;

    private void dfs(int target, int[] numbers, int cnt, int depth){
        if(depth == numbers.length){
            if(cnt == target) {
                answer++;
            }
            return;
        }
        dfs(target, numbers, cnt+numbers[depth], depth+1);
        dfs(target, numbers, cnt-numbers[depth], depth+1);
    }

    public int solution(int[] numbers, int target) {

        dfs(target, numbers, 0, 0);
        return answer;
    }


    public static void main(String[] args){
        pro2 T = new pro2();

        int[] arr = {4,1,2,1};

        T.solution(arr, 4);

    }
}
