package 프로그래머스2024;

//호텔 대실
public class pro26 {

    public int solution(String[][] book_time) {

        int answer = 0;

        //00: 00 ~ 23 : 59 범위
        int[] times = new int[25*60];
        for(String[] book : book_time){
            int start = changeMin(book[0]);
            int end = Math.min(1439, changeMin(book[1])+10);
            for(int j=start; j<end; j++){
                times[j]++;
            }
        }

        for(int i=0; i<times.length; i++){
            answer = Math.max(answer, times[i]);
        }

        return answer;
    }

    public int changeMin(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        int min = h*60+m;
        return min;
    }

    public static void main(String[] args){
        pro26 T = new pro26();
        String[][] test = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        T.solution(test);
    }
}
