package 프로그래머스2024;

import java.util.ArrayList;
import java.util.List;

//바탕화면 정리
public class pro17 {


    public int[] solution(String[] wallpaper) {


//        List<int[]> list = new ArrayList<>();

        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;

        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
//                    list.add(new int[]{i+1,j+1});
                }
            }
        }

        int[] answer = {minX, minY, maxX, maxY};

//        answer[0] = 100;
//        answer[1] = 100;
//        answer[2] = 0;
//        answer[3] = 0;
//
//        for(int i=0; i<list.size(); i++){
//            answer[0] = Math.min(answer[0], list.get(i)[0]-1);
//            answer[1] = Math.min(answer[1], list.get(i)[1]-1);
//            answer[2] = Math.max(answer[2], list.get(i)[0]);
//            answer[3] = Math.max(answer[3], list.get(i)[1]);
//        }

        return answer;
    }

    public static void main(String[] args){
        pro17 T = new pro17();

        String[] arr= {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        T.solution(arr);
    }
}
