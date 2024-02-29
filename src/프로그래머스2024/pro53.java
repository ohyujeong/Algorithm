package 프로그래머스2024;

import java.util.*;

//두 개 뽑아서 더하기
public class pro53 {

    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;

    public void dfs(int depth, int sum, int start, int[] numbers){

        if(depth==2){
            set.add(sum);
            return;
        }

        for(int i=start; i<numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, sum+numbers[i], start+1, numbers);
                visited[i] = false;
            }
        }

    }

    public int[] solution(int[] numbers) {


        visited = new boolean[numbers.length];

        dfs(0,0,0,numbers);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        pro53 T = new pro53();

        T.solution(new int[]{2,1,3,4,1});
    }
}
