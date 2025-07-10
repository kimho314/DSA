package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ10825 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;

    static class Student implements Comparable<Student> {
        public String name;
        public int korean;
        public int english;
        public int math;

        public Student() {
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean;
            }
            if (this.english != o.english) {
                return this.english - o.english;
            }
            if (this.math != o.math) {
                return o.math - this.math;
            }
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", korean=" + korean +
                    ", english=" + english +
                    ", math=" + math +
                    '}';
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Student st = new Student();
            st.name = sc.next();
            st.korean = sc.nextInt();
            st.english = sc.nextInt();
            st.math = sc.nextInt();
            students.add(st);
        }

        Collections.sort(students);
        for (int i = 0; i < N; i++) {
            sb.append(students.get(i).name).append("\n");
        }
        System.out.println(sb);
    }
}
