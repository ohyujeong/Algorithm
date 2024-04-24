package 자료구조;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class boj22866 {

    static class Building{
        int num;
        int h;
        public Building(int num, int h){
            this.num = num;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Building[] arr = new Building[N+1];
        int[][] near = new int[N+1][2];
        for(int[] row : near)
            Arrays.fill(row, 100001);
        int[] cnt = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        Stack<Building> right = new Stack<>();

        for(int i=1; i<=N; i++){
            while(!right.isEmpty() && right.peek().h <= arr[i].h) right.pop();
            cnt[i]+= right.size();
            if(!right.isEmpty()){
                int gap = Math.abs(right.peek().num-i);
                if(gap < near[i][1]){
                    near[i][0] = right.peek().num;
                    near[i][1] = gap;
                }
                else if(gap==near[i][1] && right.peek().num < near[i][0]){
                    near[i][0] = right.peek().num;
                }
            }
            right.push(arr[i]);
        }

        Stack<Building> left = new Stack<>();
        //좌측
        for(int i=N; i>=1; i--){

            while(!left.isEmpty() && left.peek().h <= arr[i].h){
                left.pop();
            }
            cnt[i] += left.size();

            if(!left.isEmpty()){
                //거리
                int gap = Math.abs(left.peek().num-i);
                if(gap<near[i][1]){
                    near[i][0] = left.peek().num;
                    near[i][1] = gap;
                }

                //거리 같으면 숫자가 더 작은 빌딩으로
                else if(gap==near[i][1] && left.peek().num<near[i][0]){
                    near[i][0] = left.peek().num;
                }
            }
            left.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(cnt[i]==0){
                sb.append(0);
            }
            else{
                sb.append(cnt[i]).append(' ').append(near[i][0]);
            }
            sb.append('\n');
        }

        System.out.println(sb);


    }
}
