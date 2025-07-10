package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ5635 {
    static FastReader SC = new FastReader();
    static int N;
    static List<Student> STUDENTS;

    private static class Student implements Comparable<Student> {
        public String name;
        public int day;
        public int month;
        public int year;

        @Override
        public int compareTo(Student o) {
            if (this.year == o.year) {
                if (this.month == o.month) {
                    return Integer.compare(this.day, o.day);
                }
                else {
                    return Integer.compare(this.month, o.month);
                }
            }
            else {
                return Integer.compare(this.year, o.year);
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Collections.sort(STUDENTS);

        System.out.println(STUDENTS.get(STUDENTS.size() - 1).name);
        System.out.println(STUDENTS.get(0).name);
    }

    private static void input() {
        N = SC.nextInt();
        STUDENTS = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = SC.nextLine();
            String[] split = input.split(" ");
            Student student = new Student();
            student.name = split[0];
            student.day = Integer.parseInt(split[1]);
            student.month = Integer.parseInt(split[2]);
            student.year = Integer.parseInt(split[3]);
            STUDENTS.add(student);
        }
    }
}
