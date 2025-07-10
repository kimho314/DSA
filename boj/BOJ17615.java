package boj;

public class BOJ17615 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        String input = SC.next();

        int firstBallCnt = 0;
        int redCnt = 0;
        int blueCnt = 0;
        int answer = Integer.MAX_VALUE;

        for (char ch : input.toCharArray()) {
            if (ch == 'R') {
                redCnt++;
            }
            else {
                blueCnt++;
            }
        }


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'R') {
                firstBallCnt++;
            }
            else {
                break;
            }
        }
        answer = Math.min(answer, redCnt - firstBallCnt);

        firstBallCnt = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == 'R') {
                firstBallCnt++;
            }
            else {
                break;
            }
        }
        answer = Math.min(answer, redCnt - firstBallCnt);

        firstBallCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'B') {
                firstBallCnt++;
            }
            else {
                break;
            }
        }
        answer = Math.min(answer, blueCnt - firstBallCnt);

        firstBallCnt = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == 'B') {
                firstBallCnt++;
            }
            else {
                break;
            }
        }
        answer = Math.min(answer, blueCnt - firstBallCnt);

        System.out.println(answer);
    }
}
