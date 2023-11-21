package hashing;

import java.util.*;

//프로그래머스 베스트 앨범
public class sol3 {

    static class Music{
        String genre;
        int playCnt;
        int idx;

        public Music(String genre, int playCnt, int idx){
            this.genre = genre;
            this.playCnt = playCnt;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays){

        HashMap<String, Integer> map = new HashMap<>();

        //장르별 총 재생횟수
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }

        //장르별 총 재생횟수 내림차순으로 저장해줌
        ArrayList<String> genresOrdered = new ArrayList<>();

        List<String> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));

        for(String key : keys){
            genresOrdered.add(key);
        }

//        while(map.size()!=0){
//            int max = Integer.MIN_VALUE;
//            String maxKey = "";
//
//            //key 기준으로 for문 돌면서 가장 큰 value를 가진 key 값 찾음
//            for(String key : map.keySet()){
//                int tmp = map.get(key);
//                if(tmp>max){
//                    max = tmp;
//                    maxKey = key;
//                }
//            }
//
//            //for문 끝난 후 가장 큰 값 ArrayList에 추가
//            genresOrdered.add(maxKey);
//
//            //map에서 제거 후 다시 while문 돎
//            map.remove(maxKey);
//        }

        //장르 내 가장 많이 재생된 노래 2개 뽑기
        ArrayList<Music> result = new ArrayList<>();
        for(String gen : genresOrdered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gen)){
                    list.add(new Music(gen,plays[i], i));
                }
            }
            Collections.sort(list,(o1, o2) -> o2.playCnt - o1.playCnt);
            result.add(list.get(0));
            if(list.size()!=1){
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }

    public static void main(String[] args){
        sol3 T = new sol3();

        String[] arr = {"classic", "pop", "classic", "classic", "pop"};
        int[] arr2 = {500, 600, 150, 800, 2500};
        T.solution(arr, arr2);
    }
}
