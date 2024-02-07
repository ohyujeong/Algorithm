package 프로그래머스2024;

import java.util.HashMap;

//단어 변환
public class pro18 {

    int answer = 0;
    int wordLen = 0;
    boolean[] visited;
    HashMap<String, Integer> hm = new HashMap<>();

    public void dfs(String begin, String target, int depth, String[] words){

        if(begin.equals(target)){
            answer = depth;
            return;
        }

        if(depth==words.length){
            return;
        }

        for(int i=0; i<words.length; i++){
            int cnt = 0;
//            for(int j=0; j<wordLen; j++){
//                if(begin.charAt(j) != words[i].charAt(j)){
//                    cnt++;
//                }
//            }
            if(check(begin, words[i]) && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, depth+1, words);
                visited[i] = false;
            }
        }
    }

    public boolean check(String now, String next){
        int cnt = 0;
        for(int j=0; j<wordLen; j++){
            if(now.charAt(j)!=next.charAt(j)){
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int solution(String begin, String target, String[] words) {

        for (String s : words) {
            hm.put(s, 0);
        }

        if (!hm.containsKey(target)) {
            return 0;
        }

        visited = new boolean[words.length];
        wordLen = begin.length();

        dfs(begin, target, 0, words);
        return answer;
    }

    public static void main(String[] args){
        pro18 T = new pro18();

        String[] words ={"hot", "dot", "dog", "lot", "log", "cog"};
        T.solution("hit", "cog", words);

    }
}
