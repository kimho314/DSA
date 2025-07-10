package boj;

import java.math.BigInteger;

public class BOJ2935 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        BigInteger n1 = new BigInteger(SC.nextLine());
        String op = SC.nextLine();
        BigInteger n2 = new BigInteger(SC.nextLine());

        if (op.equals("+")) {
            System.out.println(n1.add(n2));
        }
        if (op.equals("*")) {
            System.out.println(n1.multiply(n2));
        }
    }
}
