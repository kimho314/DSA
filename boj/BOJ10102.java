package boj;

public class BOJ10102 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int v = SC.nextInt();
        String str = SC.nextLine();

        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'A') {
                cntA++;
            }
            else {
                cntB++;
            }
        }

        if (cntA > cntB) {
            System.out.println('A');
        }
        else if (cntB > cntA) {
            System.out.println("B");
        }
        else {
            System.out.println("Tie");
        }
    }
}
