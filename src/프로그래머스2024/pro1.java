package 프로그래머스2024;

import java.util.*;

//소수찾기 (완전탐색)
public class pro1 {

//    public static boolean[] primes;

    public static int[] visited;
    public static int[] cardCnt;

    public static ArrayList<Integer> numList = new ArrayList<>();

//    private static void isPrime(int n){
//        for(int i=2; i<Math.sqrt(n); i++){
//            //i가 소수라면, i의 배수들은 i를 약수로 가지니까 소수가 아님
//            //i의 배수들을 false 처리해줌
//            if(primes[i]){
//                //i*i 이전의 수는 다 검사했으니까 i*i부터 배수 시작
//                for(int j= i*i; j<=n; j = j+i){
//                    primes[j] = false;
//                }
//            }
//        }
//    }

    private static boolean isPrime(int n) {

        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    private static void dfs(int[] cardCnt, int[] visited, int depth, int max, int num){

        if(!numList.contains(num)){
            if(num!=0 && depth<=max){
                numList.add(num);
            }
            if(depth==max){
                return;
            }
        }


        //0~9까지 숫자
        for(int i=0; i<10; i++){
            if(visited[i] < cardCnt[i]){
                visited[i] ++;
                dfs(cardCnt, visited, depth+1, max, num*10+i);
                visited[i] --;
            }
        }
    }


    public int solution(String numbers) {

        int answer = 0;
        int[] numbersArr = new int[numbers.length()];

        for(int i=0; i<numbersArr.length; i++){
            numbersArr[i] = numbers.charAt(i) - '0';
        }

        //0~9까지
        visited = new int[10];
        cardCnt = new int[10];

        for(int i=0; i< numbersArr.length; i++){
            cardCnt[numbersArr[i]] ++;
        }

        //카드에서 조합할 수 있는 숫자를 뽑음
        dfs(cardCnt, visited, 0, numbersArr.length, 0);

        //숫자별 소수 판별
        for(int i=0; i< numList.size(); i++){
            if(isPrime(numList.get(i))){
                answer++;
            };
        }



//        StringBuilder sb = new StringBuilder();
//        Arrays.sort(numbersArr);
//
//        //numbers에서 만들 수 있는 최대값
//        for(int i=numbersArr.length-1; i>=0; i--){
//            sb.append(Integer.toString(numbersArr[i]));
//        }
//
//        int max = Integer.parseInt(sb.toString());
//
//        primes = new boolean[max+1];
//
//        //0이랑 1은 소수 아니니까 그대로 fasle로 두고 true로 다 초기화
//        for(int i=2; i<primes.length; i++){
//            primes[i] = true;
//        }
//
//        //최대값에서 소수가 될 수 있는 걸 다 찾고..
//        isPrime(max);
//

//
//        for(int i=0; i<numList.size(); i++){
//            if(primes[numList.get(i)]){
//                answer++;
//            }
//        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){

        pro1 T = new pro1();

//        T.solution("17");
        T.solution("1231");

//        T.solution("23");
    }
}
