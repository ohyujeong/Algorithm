package 프로그래머스2024;

import java.util.*;

//모음 사전
public class pro60 {

    HashMap<Integer, String> dic;
    ArrayList<String> wordList;

    int answer = 0;

    public void dfs(int depth, String curWord, String word){

        wordList.add(curWord);

        if(depth==5){
            return;
        }

        if(curWord.equals(word)){
            return;
        }

        for(int i=0; i<5; i++){
            if(!wordList.contains(word)){
                answer++;
            }
            dfs(depth+1, curWord+dic.get(i), word);
        }
    }

    public int solution(String word) {
        int answer = 0;

        dic = new HashMap<>();
        wordList = new ArrayList<>();

        String[] arr = {"A","E","I","O","U"};
        for(int i=0; i<5; i++){
            dic.put(i, arr[i]);
        }

        dfs(0, "", word);

//        for(int i=0; i<wordList.size(); i++){
//            if(wordList.get(i).equals(word)){
//                answer = i;
//                break;
//            }
//        }

        return answer;
    }

    public static void main(String[] args){
        pro60 T = new pro60();

        T.solution("AAAAE");
    }
}
