package boj;

import java.util.LinkedList;

public class BOJ2083 {
    private static FastReader SC = new FastReader();
    private static LinkedList<Member> MEMBERS;

    private static class Member {
        public String name;
        public int age;
        public int weight;

        public Member(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (Member m : MEMBERS) {
            boolean isSenior = false;
            if (m.age > 17 || m.weight >= 80) {
                isSenior = true;
            }

            sb.append(m.name).append(" ").append(isSenior ? "Senior" : "Junior").append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        MEMBERS = new LinkedList<>();
        while (true) {
            String input = SC.nextLine();
            String[] split = input.split(" ");
            if (split[0].equals("#") && split[1].equals("0") && split[2].equals("0")) {
                break;
            }

            MEMBERS.add(new Member(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
    }
}
