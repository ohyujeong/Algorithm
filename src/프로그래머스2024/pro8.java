package 프로그래머스2024;

import java.util.*;

class Route{
    char op;
    int n;
    public Route(char op, int n){
        this.op = op;
        this.n = n;
    }
}

//공원 산책
public class pro8 {

    char[][] graph;

    Queue<Point> q = new LinkedList<>();
    Queue<Route> rq = new LinkedList<>();

    public int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];

        int m = park[0].length();
        graph = new char[park.length][m];

        for(int i=0; i<park.length; i++){
            for(int j=0; j<m; j++){
                graph[i][j] = park[i].charAt(j);
                if(park[i].charAt(j)=='S'){
                    q.offer(new Point(i,j));
                }
            }
        }


        for(String s : routes){
            char op = s.charAt(0);
            int n = s.charAt(2)-'0';
            rq.offer(new Route(op, n));
        }

        while(!rq.isEmpty()){

            Point tmp = q.poll();
            Route r = rq.poll();

            int nx = tmp.x;
            int ny = tmp.y;

            if(r.op == 'N'){
                nx -= r.n;
                if(nx>=0 && nx<park.length){
                    for(int i=1; i<=r.n; i++){
                        if(graph[tmp.x-i][ny] == 'X'){
                            nx = tmp.x;
                            break;
                        }
                    }
                }
                else{
                    nx = tmp.x;
                }
            }

            if(r.op == 'S'){
                nx += r.n;
                if(nx>=0 && nx<park.length){
                    for(int i=1; i<=r.n; i++){
                        if(graph[tmp.x+i][ny] == 'X'){
                            nx = tmp.x;
                            break;
                        }
                    }
                }
                else{
                    nx = tmp.x;
                }
            }

            if(r.op == 'W'){
                ny -= r.n;
                if(ny>=0 && ny<m){
                    for(int i=1; i<=r.n; i++){
                        if(graph[tmp.x][tmp.y-i] == 'X'){
                            ny = tmp.y;
                            break;
                        }
                    }
                }
                else{
                    ny = tmp.y;
                }
            }

            if(r.op == 'E'){
                ny += r.n;
                if(ny>=0 && ny<m){
                    for(int i=1; i<=r.n; i++){
                        if(graph[tmp.x][tmp.y+i] == 'X'){
                            ny = tmp.y;
                            break;
                        }
                    }
                }
                else{
                    ny = tmp.y;
                }
            }

            q.offer(new Point(nx,ny));
            answer[0] = nx;
            answer[1] = ny;
        }

        for(int i=0; i<2; i++){
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        pro8 T = new pro8();

        String[] park = {"SOOO", "OOOO", "OOOO"};
        String[] routes = {"E 3", "S 3", "S 2"};

        T.solution(park, routes);
    }
}
