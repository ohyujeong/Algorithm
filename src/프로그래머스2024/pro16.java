package 프로그래머스2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//데이터 분석
public class pro16 {


    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {


        String[] arr = {"code", "date", "maximum", "remain"};

        ArrayList<int[]> list = new ArrayList<>();

        int extIndex = 0;
        int findIndex = 0;

        for(int i=0; i<4; i++){
            if(ext.equals(arr[i])){
                extIndex = i;
            }
            if(sort_by.equals(arr[i])){
                findIndex = i;
            }
        }

        final int sortIndex = findIndex;

        for(int[] tmp : data){
            if(tmp[extIndex]<val_ext){
                list.add(tmp);
            }
        }

        int[][] answer = new int[list.size()][3];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer, (o1, o2) -> o1[sortIndex]-o2[sortIndex]);
        return answer;
    }

    public static void main(String[] args){
        pro16 T = new pro16();

        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        T.solution(data, "date", 20300501, "remain");
    }
}
