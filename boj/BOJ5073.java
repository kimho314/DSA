package boj;

public class BOJ5073 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int[] l = new int[3];
            for (int i = 0; i < 3; i++) {
                l[i] = SC.nextInt();
            }

            if (l[0] == 0 && l[1] == 0 && l[2] == 0) {
                break;
            }

            if (isInvalid(l)) {
                SB.append("Invalid").append("\n");
                continue;
            }
            else if (isEquilateral(l)) {
                SB.append("Equilateral").append("\n");
                continue;
            }
            else if (isIsosceles(l)) {
                SB.append("Isosceles").append("\n");
                continue;
            }
            else {
                SB.append("Scalene").append("\n");
            }
        }
        System.out.println(SB.toString());
    }

    private static boolean isIsosceles(int[] l) {
        return (l[0] == l[1]) || (l[1] == l[2]) || (l[0] == l[2]);
    }

    private static boolean isEquilateral(int[] l) {
        return l[0] == l[1] && l[1] == l[2];
    }

    private static boolean isInvalid(int[] l) {
        int maxIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (l[i] > l[maxIdx]) {
                maxIdx = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (i == maxIdx) {
                continue;
            }
            sum += l[i];
        }

        return l[maxIdx] >= sum;
    }
}
