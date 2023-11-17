package hashing;

import java.util.*;

//인프런 회장선거
public class SOL2_5 {

    public String solution(String[] votes, int k){


        HashMap<String, ArrayList<String>> voteHash = new HashMap<>();

        //추천자 votes[0], 후보 votes[1]
        for(int i=0; i<votes.length; i++){
            String[] keyValue = votes[i].split(" ");
            voteHash.put(keyValue[1], voteHash.getOrDefault(keyValue[1], new ArrayList<>()));
            voteHash.get(keyValue[1]).add(keyValue[0]);
        }

        HashMap<String, Integer> present = new HashMap<>();

        for(String s:voteHash.keySet()){
            if(voteHash.get(s).size()>=k){
                for(int i=0; i<voteHash.get(s).size(); i++){
                    String key = voteHash.get(s).get(i);
                    present.put(key, present.getOrDefault(key,0)+1);
                }
            }
        }

        ArrayList<String> tmp = new ArrayList<>();
        for(String s:present.keySet()){
            if(present.get(s).equals(Collections.max(present.values()))){
                tmp.add(s);
            }
        }

        Collections.sort(tmp);

        System.out.println(tmp.get(0));
        return tmp.get(0);
    }

    public static void main(String[] args){
        SOL2_5 T = new SOL2_5();

        String[] votes = {"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"};
        int k = 3;

        T.solution(votes, k);
    }
}
