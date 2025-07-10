package boj;

public class BOJ2908 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String A = String.valueOf(SC.nextInt());
        String B = String.valueOf(SC.nextInt());

        String reverseAStr = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            reverseAStr += A.charAt(i);
        }
        String reverseBStr = "";
        for (int i = B.length() - 1; i >= 0; i--) {
            reverseBStr += B.charAt(i);
        }

        int reverseA = Integer.parseInt(reverseAStr);
        int reverseB = Integer.parseInt(reverseBStr);
        System.out.println(Math.max(reverseA, reverseB));
    }
}
