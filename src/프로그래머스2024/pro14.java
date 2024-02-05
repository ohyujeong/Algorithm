package 프로그래머스2024;

//최소 직사각형
public class pro14 {

    public int solution(int[][] sizes) {

        int maxW =0;
        int maxH = 0;

        //가로 세로중 큰 크기를 가로로 한 번에 몰아넣음
        //모두 몰아넣은 상태에서 가로에서 가장 큰 값과 세로에서 가장 큰 값을 곱하면 모두 포함하는 가장 작은 지갑
        for(int i=0; i<sizes.length; i++){
//            int w = Math.max(sizes[i][0], sizes[i][1]);
//            int h = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(maxW, Math.max(sizes[i][0], sizes[i][1]));
            maxH = Math.max(maxH, Math.min(sizes[i][0], sizes[i][1]));
        }

        int answer = maxH * maxW;

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        pro14 T = new pro14();

        int[][] test = {{60,50},{30,70},{60,30},{80,40}};
        T.solution(test);
    }
}
