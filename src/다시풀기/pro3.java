package 다시풀기;

import java.util.*;


class Song{
    int playCnt;
    int songNum;
    public Song(int playCnt, int songNum){
        this.playCnt = playCnt;
        this.songNum = songNum;
    }
}

public class pro3{

        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, Integer> hm  = new HashMap<>();
            HashMap<String, ArrayList<Song>> playHm = new HashMap<>();

            for(int i=0; i<genres.length; i++){
                String key = genres[i];
                int cnt = plays[i];

                hm.put(key, hm.getOrDefault(key, 0)+cnt);
                playHm.putIfAbsent(key, new ArrayList<Song>());
                playHm.get(key).add(new Song(cnt, i));
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
            list.sort((o1, o2)->o2.getValue()-o1.getValue());

            for(String s : playHm.keySet()){
                ArrayList<Song> playList = playHm.get(s);
                playList.sort((o1, o2) -> o2.playCnt-o1.playCnt);
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : list) {
                String genre = entry.getKey();
                result.add(playHm.get(genre).get(0).songNum);
                if(playHm.get(genre).size()>=2){
                    result.add(playHm.get(genre).get(1).songNum);
                }
            }

            int[] answer = new int[result.size()];

            for(int i=0; i<result.size(); i++){
                answer[i] = result.get(i);
            }

            return answer;
        }

    public static void main(String[] args){
        pro3 T = new pro3();

        T.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
