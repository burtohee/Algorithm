package algorithm_1_starter._04_class04;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    - In arraylist,
        when the arraylist is full, the arraylist will double the old size to new size; 4 -> 8, and then copy all the old elements
        ,  8 -> 16, and then copy all the old elements


            AS 等差數列 Arithmetic Sequence:     an=a1+(n−1)d       ;  3, 5, 7, 9, 11, …（3為首項，每次增加2）            ; Sn =  ( n / 2 ) * (a1 + an)
            GS 等比數列 Geometric Sequence:      an = a1 ‧ r(n-1)    ;  2, 6, 18, 54, 162, ...（2為首項，每次乘3）        ; Sn = ( a1 * ( r^n - 1 ) ) / ( r - 1 )

    - to increase the size of arraylist, this is an GS 等比數列 Geometric Sequence, total cost is O(N); but in arraylist, when adding 1 number, the average cost is O(N) / N => o(1);
        , therefore, even the size is increasing, but ArrayList is O(1) similar to Array
 */

public class Code00_ArrayListBasic {

    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Object> mixed = new ArrayList<>();
        ArrayList<int[]> listOfArrays = new ArrayList<>();


        ArrayList<Person> people = new ArrayList<>();

        /*
            🔹 ArrayList (Resizable Array)

                    Backed by a dynamic array

                    Fast random access (get(index))

                    Slow insertion/removal in the middle
         */

        List<String> arrayList = new ArrayList<>();


        /*
            🔹 LinkedList (Doubly Linked List)

                    Backed by a doubly linked list

                    Fast insertion/removal at the beginning/middle

                    Slow random access
         */
        List<String> linkedList = new LinkedList<>();


        /*
            🔹 Vector (Legacy — Thread-Safe ArrayList)
                Like ArrayList, but synchronized

                Rarely used today — use Collections.synchronizedList or CopyOnWriteArrayList instead
         */
        List<String> vector = new Vector<>();


        /*
            🔹 Stack (Legacy — LIFO)
                Subclass of Vector, used as a Last-In-First-Out stack

                Consider using Deque (ArrayDeque or LinkedList) instead
         */
        Stack<Integer> stack = new Stack<>();


        /*
            🔹 CopyOnWriteArrayList (Thread-Safe for Concurrency)
                Safe for multithreaded environments

                Every write (add/remove) creates a new copy of the array — expensive for writes, great for read-heavy use cases
         */
        List<String> safeList = new CopyOnWriteArrayList<>();


        /*

            | Feature  | `Array`                                | `ArrayList`                                   |
            | -------- | -------------------------------------- | --------------------------------------------- |
            | Type     | Built-in data structure                | Class from Java Collections Framework         |
            | Use Case | For fixed-size collections of elements | For dynamic-size collections that grow/shrink |

            | Array                      | ArrayList                      |
            | -------------------------- | ------------------------------ |
            | Fixed size                 | Dynamic size                   |
            | Must know size at creation | Can add/remove elements freely |

            | Array                                                | ArrayList                                          |
            | ---------------------------------------------------- | -------------------------------------------------- |
            | Can hold **primitive types** (e.g., `int`, `double`) | Holds **objects only** (e.g., `Integer`, `Double`) |

            🔹 4. Performance
                Array is generally faster for fixed-size and frequent access.

                ArrayList is slower due to boxing/unboxing and resizing overhead but far more flexible.

         */

        // Array
        String[] fruits = {"apple", "banana"};
        System.out.println(fruits[0]);

        // ArrayList
                ArrayList<String> fruitsList = new ArrayList<>();
                fruitsList.add("apple");
                fruitsList.add("banana");
                System.out.println(fruitsList.get(0));


    }
}
