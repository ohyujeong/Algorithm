package hashing;

import java.util.*;

class Song{
    String genre;
    int playcnt;
    public Song(String genre, int playcnt){
        this.genre = genre;
        this.playcnt = playcnt;
    }
}

//프로그래머스 베스트 앨범
public class hash01 {

    public List<Integer> solution(String[] genres, int[] plays){

        HashMap<String, Integer> genreCnt = new HashMap<>();

        //각 장르 key, 장르별 총 재생횟수 value
        for(int i=0; i<genres.length; i++){
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0)+ plays[i]);
        }

        List<String> genreKeys = new ArrayList<>(genreCnt.keySet());

        //총 장르 횟수 내림차순 정렬
        genreKeys.sort(((o1, o2) -> genreCnt.get(o2).compareTo(genreCnt.get(o1))));

        HashMap<Integer, Song> songMap = new HashMap<>();

        //고유번호 key, 장르와 재생횟수를 value
        for(int i=0; i<plays.length; i++){
            songMap.put(i, new Song(genres[i], plays[i]));
        }

        List<Integer> songKeys = new ArrayList<>(songMap.keySet());

        //재생횟수별 내림차순 정렬
        songKeys.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return songMap.get(o2).playcnt - songMap.get(o1).playcnt;
            }
        });

        List<Integer> answer = new ArrayList<>();

        for(String s : genreKeys){
            int cnt = 0;
            for(int i : songKeys){
                if(songMap.get(i).genre.equals(s)){
                    if(cnt == 2){
                        break;
                    }
                    answer.add(i);
                    cnt++;
                }
            }
        }


        return answer;

    }

    public static void main(String[] args){
        hash01 T = new hash01();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        T.solution(genres, plays);
    }
}
