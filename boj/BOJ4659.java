package boj;

public class BOJ4659 {
    private static FastReader SC = new FastReader();
    private static char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = SC.nextLine();
            if (str.equals("end")) {
                break;
            }

            boolean isValid1 = isValid1(str);
            boolean isValid2 = isValid2(str);
            boolean isValid3 = isValid3(str);

            if (isValid1 && isValid2 && isValid3) {
                sb.append("<").append(str).append(">").append(" ").append("is").append(" ").append("acceptable.");
            } else {
                sb.append("<").append(str).append(">").append(" ").append("is").append(" ").append("not").append(" ").append("acceptable.");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isValid3(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.charAt(i) + String.valueOf(str.charAt(i + 1));
            if (!s.equals("ee") && !s.equals("oo") && str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValid2(String str) {
        boolean isValid = true;
        for (int i = 0; i < str.length() - 2; i++) {
            boolean flag1 = isVowel(str.charAt(i));
            boolean flag2 = isVowel(str.charAt(i + 1));
            boolean flag3 = isVowel(str.charAt(i + 2));
            if ((flag1 && flag2 && flag3) || (!flag1 && !flag2 && !flag3)) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private static boolean isVowel(char input) {
        for (char ch : VOWELS) {
            if (input == ch) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid1(String str) {
        boolean isValid = false;
        for (int i = 0; i < str.length(); i++) {
            for (char ch : VOWELS) {
                if (ch == str.charAt(i)) {
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                break;
            }
        }

        return isValid;
    }

}
