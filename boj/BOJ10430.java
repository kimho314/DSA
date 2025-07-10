package boj;

public class BOJ10430 {
    static FastReader SC = new FastReader();
    static int A, B, C;

    public static void main(String[] args) {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }
}
