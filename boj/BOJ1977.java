package boj;

public class BOJ1977 {
    static FastReader SC = new FastReader();
    static int N,M;
    public static void main(String[] args) {
        M = SC.nextInt();
        N = SC.nextInt();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=M; i<=N; i++){
            if(isPerfectSquare(i)){
                min = Math.min(min, i);
                sum += i;
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static boolean isPerfectSquare(int n){
        int odd = 1;
        int tmpNum = n;

        while(tmpNum > 0){
            tmpNum = tmpNum - odd;
            odd = odd + 2;
        }

        return tmpNum == 0;
    }
}
