package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.offer(i+1);
        }

        sb.append("<");

        // Queue의 사이즈가 1일 때까지 반복한다.
        while(q.size() != 1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로 보낸다.
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            // K번째 값은 poll한 후 출력한다.
            sb.append(q.poll() + ", ");
        }

        // Queue의 사이즈가 1일 때는 단순히 poll하면 된다.
        sb.append(q.poll() + ">");

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

