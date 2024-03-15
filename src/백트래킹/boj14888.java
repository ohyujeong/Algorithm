package 백트래킹;

import java.util.*;

//연산자 끼워넣기 (순열 백트래킹)
public class boj14888 {

    static int[] nums;
    static int[] ops;
    static int n;
    static int[] op;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void cal(){

        Deque<Integer> dq = new LinkedList<>();

        for(int i: nums){
            dq.add(i);
        }

        for(int i=0; i<n-1; i++){

            int op = ops[i];

            int num1 = dq.pollFirst();
            int num2 = dq.pollFirst();

            int tmp = 0;
            switch (op){
                case 0 :
                    tmp = num1+num2;
                    break;
                case 1:
                    tmp = num1-num2;
                    break;
                case 2:
                    tmp = num1*num2;
                    break;
                case 3:
                    tmp = num1/num2;
                    break;
            }
            dq.addFirst(tmp);
        }


        int result = dq.poll();
        max = Math.max(max, result);
        min = Math.min(min,result);
    }

    //연산자의 순서가 존재함 -> 순열
    public static void dfs(int depth){

        if(depth==n-1){
            cal();
            return;
        }

        for(int j=0; j<4; j++){
            if(op[j]>0){
                op[j]--;
                ops[depth]=j;
                dfs(depth+1);
                op[j]++;
            }
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        nums = new int[n];
;
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }


        //+, -, *, /
        op = new int[4];

        for(int i=0; i<4; i++){
            op[i] = sc.nextInt();
        }


        ops = new int[n-1];
        dfs(0);

        System.out.println(max);
        System.out.println(min);

    }
}
