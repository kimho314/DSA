import java.util.ArrayList;

public class KaoMo1 {
    public static void main(String[] args) {
        KaoMo1 kaoMo1 = new KaoMo1();
        String solution = kaoMo1.solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, Jane Doe", "example");
        System.out.println(solution);

    }

    public String solution(String S, String C) {
        // Implement your solution here
        String[] splitS = S.split(", ");

        ArrayList<String> addresses = new ArrayList<>();
        for (int i = 0; i < splitS.length; i++) {
            String name = "";
            String[] split = splitS[i].split(" ");
            for (int j = 0; j < split.length; j++) {
                if (j < split.length - 1) {
                    name += String.valueOf(split[j].charAt(0)).toLowerCase();
                }
                else {
                    String str = String.valueOf(split[j]).toLowerCase();
                    if (str.length() > 8) {
                        str = str.substring(0, 9).replaceAll("-", "");
                    }
                    name += str;
                }

            }

            String address = name + "@" + C.toLowerCase() + ".com";
            if (!addresses.isEmpty()) {
                int cnt = 0;
                for (int j = 0; j < addresses.size(); j++) {
                    if (addresses.get(j).replaceAll("[0-9]", "").equals(address)) {
                        cnt++;
                    }
                }

                if (cnt == 0) {
                    address = name + "@" + C.toLowerCase() + ".com";
                }
                else {
                    cnt++;
                    address = name + "" + cnt + "@" + C.toLowerCase() + ".com";
                }
            }
            addresses.add(address);
        }

        String answer = "";
        for (int i = 0; i < addresses.size(); i++) {
            String str = splitS[i] + " <" + addresses.get(i) + ">";
            answer += str;
            if (i < addresses.size() - 1) {
                answer += ", ";
            }
        }
        return answer;
    }
}
