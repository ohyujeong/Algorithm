package 프로그래머스2024;

//붕대 감기
public class pro11 {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int lastTime = attacks[attacks.length-1][0];

        int answer = health;

        //만나게 되는 몬스터 위치
        int cur=0;
        //연속 성공 횟수
        int cnt = 0;

        for(int i=1; i<=lastTime; i++){
            for(int j=cur; j<attacks.length; j++){
               //몬스터는 나타나는 시간 순으로 오름차순 정렬임으로
                //몬스터 나타났을 때 cur(몬스터 위치)를 +1 해줌 (먼저 등장한 몬스터에게 공격 받고 그 다음 몬스터 대기)
                if(attacks[j][0] == i ){
                    answer-=attacks[j][1];
                    //다음 몬스터로 이동
                    cur = j+1;
                    //연속 횟수 초기화
                    cnt=0;
                    if(answer<=0){
                        return -1;
                    }
                }
                else {
                    cnt++;
                    answer += bandage[1];
                    if(cnt==bandage[0]){
                        answer += bandage[2];
                        cnt=0;
                    }
                    if(answer>health){
                        answer=health;
                    }
                }
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args){
        pro11 T= new pro11();

        int[] band = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10},{9,15},{10,5},{11,5}};

        T.solution(band, health, attacks);
    }
}
