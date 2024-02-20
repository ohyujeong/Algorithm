package 프로그래머스2024;

import java.util.HashMap;

//숫자 문자열과 영단어
public class pro37 {

    public boolean check(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public int solution(String s) {

        StringBuilder sb = new StringBuilder();

        String[] dic = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


        for(int i=0; i<10; i++){
            s = s.replaceAll(dic[i], Integer.toString(i));
        }
//
//        HashMap<String, Integer> hm = new HashMap<>();
        //        for(int i=0; i<dic.length; i++){
//            hm.put(dic[i],i);
//        }
//
//        //3글자, 4글자, 5글자
//        for(int i=0; i<s.length(); i++){
//            String tmp = s.split("")[i];
//            //숫자일 경우 그대로 붙여줌
//            if(check(tmp)){
//                sb.append(tmp);
//            }
//            else{
//                for(int j=3; j<6; j++){
//                    if(i+j<=s.length()){
//                        String idx = s.substring(i, i+j);
//                        if(hm.containsKey(idx)){
//                            sb.append(hm.get(idx));
//                        }
//                    }
//                }
//            }
//        }

        return Integer.parseInt(s);
    }


    public static void main(String[] args){
        pro37 T = new pro37();

        T.solution("one4seveneight");
    }
}
