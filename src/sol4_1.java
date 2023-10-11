import java.util.*;

public class sol4_1 {

    public char solution(int n, String s){

        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: s.toCharArray()){
            //getOrDefault(x,0) x라는 키의 밸류값 리턴, 없으면 0 리턴
            //value 카운팅해주기
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int max = Integer.MIN_VALUE;

        //map 탐색
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }


    public static void main(String[] args){

        sol4_1 T = new sol4_1();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String str = sc.next();

        System.out.print(T.solution(N, str));
    }
}
