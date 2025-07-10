package boj;

public class BOJ9655 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int n = SC.nextInt();
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}
