package algorithm_1_starter._06_class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Code00_ShowComparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // 谁id大，谁放前！
    public static class IdComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return 1;
            } else if (o2.id < o1.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    // 谁age大，谁放前！
    public static class AgeComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) {
                return 1;
            } else if (o2.age < o1.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    // 谁age大，谁放前！
    public static class AgeAsecNameDescComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {

            if(o1.age != o2.age)
            {
//                if (o1.age < o2.age) {
//                    return -1;
//                }
////                else if (o2.age < o1.age) {
//                else {
//                    return 1;
//                }

                return Integer.compare(o1.age, o2.age);

            }
            else
            {
//                if (a.compareToIgnoreCase(b) < 0) {

                // Lexicographical
//                if (o1.name.compareTo(o2.name) < 0) {
//                    return 1;
//                } else if (o1.name.compareTo(o2.name) > 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }


//                return Integer.compare(0, o1.name.compareTo(o2.name));

                return o2.name.compareTo(o1.name);

//                return String.compare(o2.name, o1.name);

                // Fix for case-insensitive alphabetical:
                //  a.compareToIgnoreCase(b)

            }

        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].id + ", " + students[i].age);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 4, 1, 6, 8, 4, 1, 5, 8, 2, 3, 0 };
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        Student s6 = new Student("左ba", 10, 34);
        Student s7 = new Student("youba", 15, 34);
        Student s8 = new Student("zouba", 8, 34);
        Student s9 = new Student("aouba", 6, 34);
//
        Student[] students = { s1, s2, s3, s4, s5, s6, s7, s8, s9 };
        printStudents(students);
        System.out.println("=======");
        Arrays.sort(students, new IdComparator());
        printStudents(students);
        System.out.println("=======");
        System.out.println("=======");
        Arrays.sort(students, new AgeAsecNameDescComparator());
        printStudents(students);
        System.out.println("=======");

        ArrayList<Student> arrList = new ArrayList<>();
        arrList.add(s1);
        arrList.add(s2);
        arrList.add(s3);
        arrList.add(s4);
        arrList.add(s5);

        // order is insertion order
        for (Student s : arrList) {
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
        System.out.println("=======");
        arrList.sort(new IdComparator());
        for (Student s : arrList) {
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
        System.out.println("=======");
        arrList.sort(new AgeComparator());
        for (Student s : arrList) {
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }

    }

}
