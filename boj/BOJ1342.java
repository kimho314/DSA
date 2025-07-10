package boj;

public class BOJ1342 {
    static FastReader SC = new FastReader();
    static char[] CHARS;
    static char[] SELECTED;
    static int[] USED;
    static int CNT = 0;

    public static void main(String[] args) {
        CHARS = SC.next().toCharArray();
        SELECTED = new char[CHARS.length + 1];
        USED = new int['z' - 'a' + 1];
        for (char aChar : CHARS) {
            USED[aChar - 'a']++;
        }
        recFunc(1, ' ');

//        System.out.println("======");
        System.out.println(CNT);
    }

    private static void recFunc(int k, char temp) {
        if (k == CHARS.length + 1) {
//            System.out.println(Arrays.copyOfRange(SELECTED, 1, CHARS.length + 1));
            CNT++;
        }
        else {
            for (int i = 0; i < 'z' - 'a' + 1; i++) {
                if (USED[i] == 0) {
                    continue;
                }
//                if (!temp.isEmpty() && temp.charAt(temp.length() - 1) == (char) (i + 'a')) {
//                    continue;
//                }
                if (temp != ' ' && temp == (char) (i + 'a')) {
                    continue;
                }

                SELECTED[k] = (char) ((char) i + 'a');
                USED[i]--;
//                recFunc(k + 1, temp + (char) ('a' + i));
                recFunc(k + 1, (char) ('a' + i));
                USED[i]++;
            }
        }
    }
}
