package _06_class06;

import java.util.*;

public class ShowComparator2 {

    public static class MyComparator implements Comparator<Integer> {

        // 负，第一个参数在前
        // 正，第二个参数在前
        // 0, 谁放前都行
        @Override
        public int compare(Integer o1, Integer o2) {
//            if (o1 < o2) {
//                return 1;
//            } else if (o1 > o2) {
//                return -1;
//            } else {
//                return 0;
//            }
            return Integer.compare(o2 , o1);
        }

    }

    public static class MyStringComparator implements Comparator<String> {

        // 负，第一个参数在前
        // 正，第二个参数在前
        // 0, 谁放前都行
        @Override
        public int compare(String o1, String o2) {

            return o2.compareTo(o1);
        }

    }

    public static class Student implements Comparable<Student> {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

//        if (s5.compareTo(s4) > 0) {
//            System.out.println("s5 is older than s4");
//        }
        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.age, other.age); // compare by age
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

    public static <T> void printPriorityQueue(PriorityQueue<T> priorityQueue) {
        PriorityQueue<T> copy = new PriorityQueue<>(priorityQueue);
        while (!copy.isEmpty()) {
            System.out.print(copy.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "b";
        System.out.println(str1.compareTo(str2));
        System.out.println("=========");

        // similar stack, but will sort it for u, O(logN)
        PriorityQueue<Integer> heapBasic = new PriorityQueue<>();
        heapBasic.add(6);
        heapBasic.add(2);
        heapBasic.add(3);
        heapBasic.add(1);
        heapBasic.add(7);
        System.out.println(heapBasic.peek());
        System.out.println("=========");
        heapBasic.add(0);
        System.out.println(heapBasic.peek());
        System.out.println("=========");
        heapBasic.add(0);

        printPriorityQueue(heapBasic);

        System.out.println(heapBasic.peek());
        System.out.println("=========");
        System.out.println(heapBasic.poll());
        System.out.println("=========");
        System.out.println(heapBasic.poll());
        System.out.println("=========");
        System.out.println(heapBasic.peek());
        System.out.println("=========");

        // similar stack but this time DESC, max heap, but will sort it for u, O(logN)
        PriorityQueue<Integer> heapBasicMax = new PriorityQueue<>(new MyComparator());
        heapBasicMax.add(6);
        heapBasicMax.add(2);
        heapBasicMax.add(3);
        heapBasicMax.add(1);
        heapBasicMax.add(7);
        System.out.println(heapBasicMax.peek());
        System.out.println("=========");
        heapBasicMax.add(0);
        System.out.println(heapBasicMax.peek());
        System.out.println("=========");
        heapBasicMax.add(0);

        printPriorityQueue(heapBasicMax);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        if(s4.compareTo(s5) <0)
        {
            System.out.println("S5 > s4");
        }
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        System.out.println("=========");
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }

        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());
        TreeMap<String, Student> treeMap2 = new TreeMap<>(new MyStringComparator());
        TreeMap<Student, Student> treeMap = new TreeMap<>(new IdComparator());

        // java lambda
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Collections.sort(names, (a, b) -> a.compareTo(b));
    }

}
