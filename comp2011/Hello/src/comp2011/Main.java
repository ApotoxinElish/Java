package comp2011;

class Student implements Comparable<Student> {
    String name;
    String id;
    String major;
    String email;

    public int compareTo(Student s2) {
        return name.compareTo(s2.name);
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Student a = new Student(), b = new Student();
        a.name = "abcd";
        b.name = "bcde";
        System.out.println(a.compareTo(b));
        System.out.println("Welcome to comp2011!");
    }
}
