package 프로그래머스2024;

import java.util.*;

//셔틀 버스
public class pro51 {
    public String solution(int n, int t, int m, String[] timetable) {

        String answer = "";

        int lastTime= getTime("9:00")+((n-1)*t);

        List<Integer> crew = new LinkedList<>();

        for(String s : timetable){
            int time = getTime(s);
            crew.add(time);
        }

        Collections.sort(crew);

        int cur = 540;
        int cnt = 0;
        int j=1;

        while(!crew.isEmpty()){
            int time = crew.get(0);
            if(j==n && cnt==m-1){
                answer = getTimeFormat(time-1);
            }
            if(time<=cur && cnt<m){
                cnt++;
                crew.remove(0);
            }
            else{
                //대기열 시간이 cur보다 후거나 탑승인원이 다 찼으면 다음 버스를 보냄
                //버스 운행횟수가 아직 n보다 작을 시에만
                if(j<n){
                    j++;
                    cur += t;
                    cnt = 0;
                    if(time<=cur){
                        cnt++;
                        crew.remove(0);
                    }
                }
                else{
                    break;
                }
            }
        }

        if(cnt<m){
            answer = getTimeFormat(lastTime);
        }

        return answer;
    }

    public String getTimeFormat(int i){
        String hour = Integer.toString(i/60);
        String min = Integer.toString(i%60);
        if(Integer.parseInt(hour)<10){
            hour = "0"+hour;
        }
        if(Integer.parseInt(min)<10){
            min = "0"+min;
        }
        return hour+":"+min;
    }

    public int getTime(String s){
        String[] arr = s.split(":");
        int time = Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
        return time;
    }

    public static void main(String[] args){
        pro51 T = new pro51();

        System.out.println(T.solution(3,1,2, new String[]{"06:00", "23:59", "05:48", "00:01", "00:01"}));
        System.out.println(T.solution(1,1,5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
    }
}
