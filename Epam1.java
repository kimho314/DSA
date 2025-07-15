public class Epam1 {
    public static void main(String[] args) {
        Epam1 sol = new Epam1();
        String s = "796115110113721110141108";
        System.out.println(sol.solution(s)); // PrepInsta
    }

    private String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = s.length() - 1;
        while (idx >= 0) {
            int n1 = s.charAt(idx) - '0';
            idx--;
            int n2 = s.charAt(idx) - '0';
            int tmp = n1 * 10 + n2;
            boolean valid = isValid(tmp);
            if (valid) {
                sb.append((char) tmp);
            }
            else {
                idx--;
                int n3 = s.charAt(idx) - '0';
                tmp = n1 * 100 + n2 * 10 + n3;
                sb.append((char) tmp);
            }
            idx--;
        }

        return sb.toString();
    }

    private boolean isValid(int n) {
        if (n == 32) return true;
        if (n >= 65 && n <= 90) return true;
        return n >= 97 && n <= 122;
    }
}
