package 탐색과정렬;

import java.util.*;

public class BOJ_2751 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }

//        for(int value : list){
//            sb.append(value).append('\n');
//        }
//

//        list.forEach(value -> sb.append(value).append('\n'));
        System.out.println(sb);

    }


}
