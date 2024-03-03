package 프로그래머스2024;

//소수 찾기
public class pro57 {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<n+1; i++){
            int num = i;
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(num); j++){
                if(num % j ==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        pro57 T = new pro57();

        T.solution(5);
    }
}
