
import java.io.*;

public class sol1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String s = br.readLine();

        String[] arr = new String[str.length()];

        for(int i=0; i<str.length(); i++){
            arr[i] = Character.toString(str.charAt(i));
        }


        int answer = 0;

        for(int i=0; i< arr.length; i++){
            if(arr[i].equalsIgnoreCase(s)){
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
