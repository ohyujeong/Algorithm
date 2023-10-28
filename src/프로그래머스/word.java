package 프로그래머스;

import java.util.*;

//단어변환
public class word {

    static int answer = 51;
    static boolean[] visited;

    public void dfs(int depth, String begin, String target, String[] words){

        // == 은 주소값을 비교함
        if(begin.equals(target)){
            answer = Math.min(answer,depth);
            return;
        }

        for(int i=0; i<words.length; i++){
            //다른게 하나면 탐색 ㄱㄱ 한 개만 단어를 바꿀 수 있음
            if(check(begin, words[i]) && !visited[i]){
                visited[i] = true;
//                System.out.println("depth" + depth + " detph +1 :" + (depth+1));
//                System.out.println("depth" + depth + " detph ++ :" + (depth++));
                dfs(depth+1, words[i], target, words);
                //모든 경우의 수 탐색을 위해 false
                visited[i] = false;
            }
        }
    }

    public boolean check(String now, String next){
        int count =0;
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                count++;
            }
        }

        //count 1이면 true 반환
        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(0, begin, target, words);
//        System.out.println(answer);

        if(answer == 51){
            return 0;
        }
        return answer;
    }

    public static void main(String[] args){
        word T = new word();

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        T.solution("hit", "cog",words);
    }
}
