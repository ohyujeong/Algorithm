package 시뮬레이션_구현;

public class boj4673 {
    public static void main(String[] args){

        int[] arr = new int[10001];

        for(int i=1; i<arr.length; i++){
            int num = i;
            int sum = num;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            if(sum<arr.length){
                arr[sum]++;
            }
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i]==0){
                System.out.println(i);
            }
        }


    }
}
