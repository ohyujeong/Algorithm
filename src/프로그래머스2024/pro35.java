package 프로그래머스2024;

//크기가 작은 부분 문자열
public class pro35 {

    public int solution(String t, String p) {
        int answer = 0;

        int n = p.length();
        long pNum = Long.parseLong(p);


        for(int i=0; i<=t.length()-n; i++){
            String tmp = t.substring(i, i+n);
            long num = Long.parseLong(tmp);
            if(num<=pNum){
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args){

        pro35 T= new pro35();

        T.solution("3141592", "271");

    }
}
