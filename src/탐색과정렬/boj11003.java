package 탐색과정렬;

import java.util.*;
import java.io.*;

//최솟값 찾기
public class boj11003 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!q.isEmpty() && q.getLast().value >now){
                q.removeLast();
            }
            q.addLast(new Node(now, i));

            if(q.getFirst().idx<=i-L){
                q.removeFirst();
            }

            bw.write(q.getFirst().value+" ");
        }

        bw.flush();
        bw.close();

    }

    static class Node{
        public int value;
        public int idx;
        Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
}


