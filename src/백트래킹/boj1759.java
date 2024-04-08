package 백트래킹;

import java.util.*;
import java.io.*;
//암호 만들기
public class boj1759 {

    static String[] arr;
    static boolean[] visited;
    static int L,C;
    static List<Character> vowel;

    private static void combi(int depth, int start, StringBuilder sb){
        if(depth==L){
            int vCnt = 0;
            boolean flag = false;
            for(int i=0; i<sb.length(); i++){
                if(vowel.contains(sb.charAt(i))){
                    vCnt++;
                    flag = true;
                }
            }
            if(flag && vCnt<=L-2){
                System.out.println(sb);
            }
            return;
        }

        for(int i = start; i<C; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(depth+1, i+1, sb.append(arr[i]));
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];
        vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);


        combi(0, 0, new StringBuilder());

    }
}
