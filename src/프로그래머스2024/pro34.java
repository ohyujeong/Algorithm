package 프로그래머스2024;

import java.util.*;

//수식 최대화
class pro34 {

    long answer = 0;
    ArrayList<Long> nums;
    ArrayList<Character> ops;
    ArrayList<Character> opList;
    HashSet<Character> hs;
    boolean[] visited;
    HashMap<Character, Integer> priority;

    public void dfs(int depth){

        if(depth == opList.size()){
            answer = Math.max(answer, Math.abs(cal()));
            return;
        }

        for(int i=0; i<opList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                priority.put(opList.get(i), depth);
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }

    public long cal(){

        ArrayList<Character> tmpOps = new ArrayList<>(ops);
        ArrayList<Long> tmpNums = new ArrayList<>(nums);

        int order = 0;
        int n = tmpOps.size();
        order = getPriority(tmpOps);

        for(int i=0; i<tmpOps.size(); i++){

            if(tmpOps.size()!=n){
                order = getPriority(tmpOps);
            }
            char ch = tmpOps.get(i);

            //최우선순위면 계산하기
            if(priority.get(ch)==order){
                long tmp = 0;
                switch (ch){
                    case '+':
                        tmp = tmpNums.get(i)+tmpNums.get(i+1);

                        break;

                    case '*':

                        tmp = tmpNums.get(i)*tmpNums.get(i+1);

                        break;
                    case '-':

                        tmp  = tmpNums.get(i)-tmpNums.get(i+1);

                        break;
                }

                tmpNums.remove(i);
                tmpNums.remove(i);
                tmpNums.add(i, tmp);
                tmpOps.remove(i);
                i=-1;
            }
        }

        return tmpNums.get(0);
    }

    public int getPriority(ArrayList<Character> op){

        int maxPr = 3;

        //남은 연산자 중에서 최우선순위(0,1,2) 순서
        for(int i=0; i<op.size(); i++){
            maxPr=Math.min(maxPr, priority.get(op.get(i)));
        }

        return maxPr;
    }

    public long solution(String expression) {

        String num ="";
        ops = new ArrayList<>();
        nums = new ArrayList<>();
        priority = new HashMap<>();

        hs = new HashSet<>();
        opList = new ArrayList<>();

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                hs.add(ch);
                ops.add(ch);
                nums.add(Long.parseLong(num));
                num = "";
            }
            else{
                num+=ch;
            }
        }

        opList.addAll(hs);
        visited = new boolean[opList.size()];

        nums.add(Long.parseLong(num));
        dfs(0);

        return answer;
    }



    public static void main(String[] args){
        pro34 T = new pro34();

        System.out.println(T.solution("100-200*300-500+20"));
    }
}