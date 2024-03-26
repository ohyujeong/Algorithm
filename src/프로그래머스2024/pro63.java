package 프로그래머스2024;

//두 큐 합 같게 만들기
public class pro63 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long q1 = 0;
        long q2 = 0;

        for(long i : queue1){
            q1+=i;
        }

        for(long i : queue2){
            q2+=i;
        }

        if((q1+q2)%2!=0){
            return -1;
        }

        long target = (q1+q2)/2;

        int l = 0;
        int r =0;

        int p2=0;

        int n = queue1.length;

        while(true){
            if(q1<target && r<n){
                q1+=queue2[r++];
                answer++;
            }
            else if(q1>target && (l<n || p2<n)){
                int cur = 0;
                if(l>=n){
                    cur=queue2[p2++];
                }
                else{
                    cur=queue1[l++];
                }
                q1-=cur;
                answer++;
            }
            else if(q1!=target){
                answer = -1;
                break;
            }
            else{
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        pro63 T = new pro63();

        T.solution(new int[]{3,2,7,2}, new int[]{4,6,5,1});
        T.solution(new int[]{1,2,1,2}, new int[]{1,10,1,2});
        T.solution(new int[]{1,1}, new int[]{1,5});
        T.solution(new int[]{1,4}, new int[]{4,8});
    }
}
