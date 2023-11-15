package DFS;

import java.util.*;

//줄다리기
public class SOL6_2 {

    static int[] ch;
    static int[][] relation;
    static int answer = 0;
    static Stack<Integer> pm;

    public void dfs(int depth){

        if(depth == 7){
            answer++;
        }
        else{
            for(int i=1; i<8; i++){
                if(!pm.empty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm.push(i);
                    dfs(depth+1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] nums){

        pm = new Stack<>();
        relation = new int[8][8];
        ch = new int[8];

        for(int i=0; i<nums.length; i++){
            relation[nums[i][0]][nums[i][1]] = 1;
            relation[nums[i][1]][nums[i][0]] = 1;
        }

        dfs(0);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        SOL6_2 T = new SOL6_2();

        int[][] nums = {{1,3},{5,7},{4,2}};
        T.solution(nums);
    }
}
