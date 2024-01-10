package 자료구조;

import java.util.*;



//2024 카카오 윈터 인턴십 기출 - 가장 많이 받은 선물
public class pro1 {

    public int solution(String[] friends, String[] gifts) {

        //선물 지수
        HashMap<String, Integer> giftValue = new HashMap<>();

        //선물 지수에 이름 세팅
        //gifts에 아예 이름이 없는 경우에 이름 세팅을 먼저 안 해주면 선물 지수 비교할 때
        // 이름이 없는데 접근을 하려고 해서 인덱스 오류남!
        for(String s : friends){
            giftValue.put(s, giftValue.getOrDefault(s, 0));
        }

        //선물 지수 계산
        for(String s : gifts){
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];

            //선물을 줬으면 +1
            if(giftValue.containsKey(from)){
                giftValue.put(from, giftValue.get(from)+1);
            }
            //선물을 받았으면 -1
            if(giftValue.containsKey(to)){
                giftValue.put(to, giftValue.get(to)-1);
            }
        }


        //a가 b에게 선물을 줬으면 a가 key이고 b자리 배열값에 +1
        //b는 a에게 선물을 받았으니까 b가 key이고 a자리 배열값에 -1
        HashMap<String, int[]> giftMatch = new HashMap<>();

        //이름과 0으로 초기화한 배열을 넣어서 해쉬맵 생성
        for(String s : friends){
            int[] arr = new int[friends.length];
            giftMatch.put(s, arr);
        }

        for(String s : gifts){
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];

            //선물을 준 사람일 때
            if(giftMatch.containsKey(from)){
                //받은 사람의 인덱스값을 찾아옴
                int toIndex = Arrays.asList(friends).indexOf(to);
                //준 사람을 key로 하는 맵의 밸류값에서 받은 사람의 인덱스값을 ++;
                giftMatch.get(from)[toIndex] ++;
            }
            if(giftMatch.containsKey(to)){
                int fromIndex = Arrays.asList(friends).indexOf(from);
                giftMatch.get(to)[fromIndex] --;
            }
        }

        //선물 받는 거 저장하는 임시배열
        int[] temp = new int[friends.length];

        //s가 주체임
        for(String s : giftMatch.keySet()){
            //s의 인덱스 값을 찾아옴
            int fromIndex = Arrays.asList(friends).indexOf(s);

            //'s'가 key일 때, s와 누가 선물 주고 받았는지 알아야 하니까 총 인물의 수만큼 반복분 돌림
            for(int i=0; i< friends.length; i++){
                //0보다 크면 s가 i번째 사람과 선물을 주고 받은 기록 있음, s가 선물 더 많이 준 거니까 받아야됨
                if(giftMatch.get(s)[i]>0){
                    temp[fromIndex] ++;
                }

                //0이면 선물 주고 받은 기록 없는거임 선물지수 비교해야됨
                if(giftMatch.get(s)[i]==0){
                    //s의 선물지수가 클 때 선물 받음. (같을 때는 어차피 선물을 안 받으니까 s와 freinds배열에서 s를 똑같이 비교하는 경우는 어차피 고려 XX)
                    if(giftValue.get(s) > giftValue.get(friends[i])){
                        temp[fromIndex] ++;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int n : temp){
            if(n>max){
                n = max;
            }
        }

        return max;
    }

    public static void main(String args[]){

        String[] arr1 = {"muzi", "ryan", "frodo", "neo"};
        String[] arr2 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        pro1 T = new pro1();
        T.solution(arr1, arr2);
    }
}
