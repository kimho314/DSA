package boj;

import java.util.Arrays;
import java.util.HashSet;

public class BOJ2535 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static Student[] STUDENTS;
    private static HashSet<Integer> NATION;

    private static class Student implements Comparable<Student> {
        public int nation;
        public int num;
        public int score;

        public Student(int nation, int num, int score) {
            this.nation = nation;
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Student s) {
            return s.score - this.score;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(STUDENTS);

        int[] medals = new int[NATION.size() + 1];

        Student gold = null;
        Student silver = null;
        Student bronze = null;
        for (int i = 0; i < N; i++) {
            if (gold != null && silver != null && bronze != null) {
                break;
            }

            Student s = STUDENTS[i];
            medals[s.nation]++;
//            System.out.println(s.nation + " " + s.num + " " + Arrays.toString(medals));
            if (medals[s.nation] <= 2) {
                if (gold == null) {
                    gold = s;
                    continue;
                }
                if (gold != null && silver == null) {
                    silver = s;
                    continue;
                }
                if (gold != null && silver != null && bronze == null) {
                    bronze = s;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(gold.nation).append(" ").append(gold.num).append("\n")
                .append(silver.nation).append(" ").append(silver.num).append("\n")
                .append(bronze.nation).append(" ").append(bronze.num);
        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        STUDENTS = new Student[N];
        NATION = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int nation = SC.nextInt();
            int num = SC.nextInt();
            int score = SC.nextInt();
            Student s = new Student(nation, num, score);
            STUDENTS[i] = s;
            NATION.add(nation);
        }
    }
}
