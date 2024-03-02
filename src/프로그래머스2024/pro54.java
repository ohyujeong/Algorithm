package 프로그래머스2024;

//옹알이
public class pro54 {

    public int solution(String[] babbling) {
        int answer = 0;

        String[] dic = { "aya", "ye", "woo", "ma" };
        String[] not = {"ayaaya", "yeye", "woowoo", "mama"};

        for(String s : babbling){
            String tmp = s;
            int cnt = 0;

            for(int i=0; i<4; i++){
                if(tmp.contains(not[i])){
                    break;
                }
                tmp = tmp.replace(dic[i], "-");
            }
            for(int i=0; i<tmp.length(); i++){
                if(tmp.charAt(i)=='-'){
                    cnt++;
                }
            }
            if(tmp.equals("-".repeat(cnt))){
                answer++;
            }
        }


        return answer;
    }


    public static void main(String[] args){

        pro54 T = new pro54();

        System.out.println(T.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));

    }
}
