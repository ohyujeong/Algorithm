import java.util.Scanner;

public class sol2 {

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String str = sc.next();

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                Character temp = Character.toLowerCase(str.charAt(i));
                answer.append(temp);
            }
            else if(Character.isLowerCase(str.charAt(i))){
                Character temp = Character.toUpperCase(str.charAt(i));
                answer.append(temp);
            }
        }

        System.out.println(answer);
    }
}