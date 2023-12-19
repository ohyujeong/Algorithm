package greedy;

import java.util.*;


class Lecture implements Comparable<Lecture>{
    int m;
    int d;
    public Lecture(int m, int d){
        this.m = m;
        this.d = d;
    }

    @Override()
    public int compareTo(Lecture o){
        return o.d - this.d;
    }

}

public class sol9_4 {

    public int solution(ArrayList<Lecture> arr){

        Collections.sort(arr);

        int answer = 0;
        int max = arr.get(0).d;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        //j for문에서 0으로 초기화 안 하고 외부에 선언
        //이미 q에 넣은 강의를 또 넣으면 안 되니까..
        int j = 0;

        for(int i=max; i>=1; i--){
            for(; j<arr.size(); j++){
                if(arr.get(j).d < i){
                    break;
                }
                pQ.offer(arr.get(j).m);
            }
            if(!pQ.isEmpty()){
                answer+=pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args){
        sol9_4 T = new sol9_4();


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Lecture> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m,d));
        }

        System.out.println(T.solution(arr));
    }
}
