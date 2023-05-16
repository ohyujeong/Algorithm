package 탐색과정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arry = new ArrayList<>(set);
        Collections.sort(arry);

        for(int i=0; i<arry.size(); i++){
            sb.append(arry.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
