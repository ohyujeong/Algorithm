import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class sol3 {

    public static String solution(String str){

        String answer = "";


        //최대값 찾는 변수, 처음엔 가장 작은 값으로 초기화
        int max = Integer.MIN_VALUE, pos;

//        //띄어쓰기 기준으로 split해서 String 배열에 저장
//        String[] s = str.split(" ");
//        for(String x : s){
//            int len = x.length();
//            //기존 max보다 더 긴 단어가 있으면 단어 교체
//            if(len>max){
//                max = len;
//                answer =x;
//            }
//        }
//        return answer;

        //indexOf() 특정 문자나 문자열에서 해당하는 문자의 인덱스값 반환하고 찾지 못하면 -1 반환
        //띄어쓰기의 위치를 찾음 Hello Hi World면 띄어쓰기 첫 index는 5
        while((pos = str.indexOf(' '))!= -1){
            //0부터 띄어쓰기 전까지 string잘라서 단어 추출
            String temp = str.substring(0, pos);
            int length = temp.length();
            //>= 같은것까지 비교하면 단어 길이가 같을 때 앞쪽이 아니라 뒤에 있는 단어로 대체되니까 클 때만 비교
            if(length>max){
                max = length;
                answer =temp;
            }
            //띄어쓰기 후까지 문장을 잘라서 다시 반복
            str = str.substring(pos+1);
        }

        if(str.length() > max){
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(sol3.solution(str));
    }
}
