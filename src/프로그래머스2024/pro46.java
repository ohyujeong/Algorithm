package 프로그래머스2024;

//최댓값과 최솟값
public class pro46 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] arr = s.split(" ");
//        int cnt = 1;
//
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i)==' '){
//                cnt++;
//            }
//        }

        for(int i=0; i<arr.length; i++){
            int num = Integer.parseInt(s.split(" ")[i]);
            if(num<min){
                min = num;
            }
            if(num>max){
                max = num;
            }
        }

        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }

    public static void main(String[] args){
        pro46 T = new pro46();


//        System.out.println(T.solution("1 2 3 4"));
        System.out.println(T.solution("-1 -2 -3 -4"));
    }
}
