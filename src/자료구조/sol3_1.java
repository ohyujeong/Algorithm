package 자료구조;

import java.util.*;

//인프런 최대길이 연속수열
public class sol3_1 {
    public int solution(int[] nums){

        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }

        if(hs.size()==1){
            return 1;
        }

        int answer = 0;

        //set에서 탐색하는건 O(1)
        for(int i : hs){
            int cnt = 1;
            //i보다 -1 작은 숫자 있으면 i가 시작지점이 아님
            if(hs.contains(i-1)){
                continue;
            }
            //시작지점인 숫자에서부터 연속수열 카운팅
            else{
                while(hs.contains(i+1)){
                    cnt++;
                    i++;
                }
                answer = Math.max(answer, cnt);
            }
        }

//        List<Integer> hsList = new ArrayList<>(hs);
//
//        if(hsList.size()==1){
//            return 1;
//        }

//        Collections.sort(hsList);

//        Stack <Integer> s = new Stack<>();
//        int i=0;
//        for(; i<hsList.size()-1; ){
//            s.push(hsList.get(i));
//            while(!s.isEmpty()){
//                int cur = s.peek();
//                int next = i+1;
//                if(next==hsList.size()-1){
//                    if(cur+1==hsList.get(next)){
//                        result.add(s.size()+1);
//                    }
//                    else{
//                        result.add(s.size());
//                    }
//                    s.clear();
//                }
//                if(next<hsList.size()-1 && cur+1==hsList.get(next)){
//                    s.push(hsList.get(i+1));
//                }
//                else{
//                    result.add(s.size());
//                    s.clear();
//                }
//                i++;
//            }
//        }


        return answer;
    }

    public static void main(String[] args){
        sol3_1 T = new sol3_1();

          System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
          System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
