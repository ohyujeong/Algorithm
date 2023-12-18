package greedy;

import java.util.*;

class Time implements Comparable<Time>{

    int t;
    char state;

    public Time(int t, char state){
        this.t = t;
        this.state = state;
    }

    @Override
    public int compareTo(Time o){
        if(this.t == o.t){
            return this.state - o.state;
        }
        else{
            return this.t - o.t;
        }
    }
}


public class sol9_3 {


    public int solution(ArrayList<Time> arr){

        int cnt = 0;
        int answer = Integer.MIN_VALUE;

        Collections.sort(arr);

        for(int i=0; i<72; i++){
            for(Time ob : arr){
                if(ob.t == i && ob.state == 's'){
                    cnt++;
                    if(cnt>answer){
                        answer = cnt;
                    }
                }
                else if(ob.t == i && ob.state == 'e'){
                    cnt--;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args){

        sol9_3 T = new sol9_3();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x,'s'));
            arr.add(new Time(y, 'e'));
        }

        System.out.println(T.solution(arr));
    }
}
