package boj;

public class BOJ5622 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String input = SC.nextLine();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int score = getScore(ch);
            sum += score;
        }
        System.out.println(sum);
    }

    private static int getScore(char ch) {
        int res = -1;
        switch (ch) {
            case 'A':
            case 'B':
            case 'C':
                res = 3;
                break;
            case 'D':
            case 'E':
            case 'F':
                res = 4;
                break;
            case 'G':
            case 'H':
            case 'I':
                res = 5;
                break;
            case 'J':
            case 'K':
            case 'L':
                res = 6;
                break;
            case 'M':
            case 'N':
            case 'O':
                res = 7;
                break;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                res = 8;
                break;
            case 'T':
            case 'U':
            case 'V':
                res = 9;
                break;
            case 'X':
            case 'W':
            case 'Y':
            case 'Z':
                res = 10;
                break;
        }

        return res;
    }
}
