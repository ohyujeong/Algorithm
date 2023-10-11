import java.util.*;


public class sol4_2 {


    public String solution(String str1, String str2){

        String answer = "YES";


        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x: str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0){
                return "NO";
            }

            //key가 있으면 -1 해줌
            map.put(x, map.get(x) -1);
        }

        return answer;
    }



    public static void main(String[] args){
        sol4_2 T = new sol4_2();

        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();


        System.out.println(T.solution(str1, str2));

    }
}
