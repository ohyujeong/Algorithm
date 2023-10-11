import java.util.*;


public class sol4_4 {


    public int solution(char[] s, String t){

        int answer=0;

        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        for(char x: t.toCharArray()){
            t_map.put(x, t_map.getOrDefault(x, 0)+1);
        }

        for(int i=0; i<t.length()-1; i++){
            s_map.put(s[i], s_map.getOrDefault(s[i],0)+1);
        }

        int lt = 0;

        for(int rt=t.length()-1; rt<s.length; rt++){
            s_map.put(s[rt], s_map.getOrDefault(s[rt],0)+1);
            if(s_map.equals(t_map)){
                answer++;
            }
            s_map.put(s[lt], s_map.get(s[lt])-1);
            if(s_map.get(s[lt]) == 0 ){
                s_map.remove(s[lt]);
            }
            lt++;
        }
        return answer;
    }



    public static void main(String[] args){

        sol4_4 test = new sol4_4();

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();


        System.out.println(test.solution(S.toCharArray(),T));

    }
}
