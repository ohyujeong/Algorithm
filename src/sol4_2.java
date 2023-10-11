import java.util.*;


public class sol4_2 {


    public String solution(String str1, String str2){

        String answer = null;


        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x: str2.toCharArray()){
            map.put(x, map.getOrDefault(x,0)-1);
        }

        //map 탐색
        for(char key : map.keySet()){
            if(map.get(key)!=0){
                answer = "NO";
                return answer;
            }
        }

        answer = "YES";
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
