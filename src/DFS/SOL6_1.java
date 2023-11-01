package DFS;

import java.util.*;

//가장 가까운 큰 수
public class SOL6_1 {

    static boolean[] visited;
    static int answer,target,m;
    static ArrayList<Integer> nums = new ArrayList<>();
    static boolean flag;

    public void dfs(int depth, int number){
        if(flag){
            return;
        }
        if(depth == m){
            if(number>target){
                answer = number;
                flag = true;
            }
        }
        else{
            for(int i=0; i<m; i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(depth+1, number*10+nums.get(i));
                    visited[i] = false;
                }
            }
        }
    }

    public int solution(int n){

        target = n;

        while(n>0){
            int t = n%10;
            nums.add(t);
            n = n/10;
        }

        Collections.sort(nums);

        m = nums.size();
        visited = new boolean[m];

        dfs(0,0);
        if(!flag) return -1;
        return answer;

    }


    public static void main(String[] args){

        SOL6_1 T = new SOL6_1();

        T.solution(27711);
    }
}
