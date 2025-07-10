package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ7568 {
    static FastReader SC = new FastReader();
    static int N;

    static class Student implements Comparable<Student> {
        int num;
        int weight;
        int height;


        @Override
        public int compareTo(Student o) {
            if (weight > o.weight && height > o.height) {
                return 1;
            }
            else if (weight < o.weight && height < o.height) {
                return -1;
            }
            else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "num=" + num +
                    ", weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Student student = new Student();
            student.num = i;
            student.weight = SC.nextInt();
            student.height = SC.nextInt();
            students.add(student);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            int rank = 1;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(i).num == students.get(j).num) {
                    continue;
                }
                if (students.get(i).compareTo(students.get(j)) < 0) {
                    rank++;
                }
            }
//            System.out.println(students.get(i).num + " : " + rank);
            sb.append(rank).append(' ');
        }
        System.out.println(sb);
    }
}
