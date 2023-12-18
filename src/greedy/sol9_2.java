package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    //시작시간 s
    //끝나는 시간 e
    public int s, e;
    Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        //끝나는 시간이 같으면 시작시간 기준으로 오름차순 정렬
        if(this.e == o.e) return this.s-o.s;
        else return this.e-o.e;
    }
}

public class sol9_2 {


    public int solution(ArrayList<Time> arr, int n){
        int cnt =0;

        Collections.sort(arr);
        int endTime = 0;

        for(Time ob : arr){
            if(ob.s >= endTime){
                cnt++;
                endTime = ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args){

        sol9_2 T = new sol9_2();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Time> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x,y));
        }

        System.out.println(T.solution(arr,n));

    }
}
