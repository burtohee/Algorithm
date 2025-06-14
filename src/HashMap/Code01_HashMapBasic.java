package HashMap;

import java.util.*;

public class Code01_HashMapBasic {

    public static class Node implements Comparable<Node>, Comparator<Node> {

        public int value;
        public Node(int v)
        {
            value = v;
        }

        @Override
        public int compareTo(Node other)
        {
            return Integer.compare(value, other.value);
        }
        @Override
        public int compare(Node other1, Node other2)
        {
            return Integer.compare(other1.value, other2.value);
        }
    }


    /*
            - Hashmap, no matter what size is,
                add,delete,update is O(1), but this O(1) is large, slower than +;-;arr[0]
     */

    // (K,V) table
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<>();

        map.put("Burto", "My name is Burto He");

        boolean ifExist = map.containsKey("Burto");
        System.out.println("Burto: " + ifExist);
        ifExist = map.containsKey("zuo");
        System.out.println("zuo: " + ifExist);

        String valueGet= map.get("Burto");
        System.out.println("value get: " + valueGet);

        map.put("Burto", "My name is Burto He new");
        valueGet= map.get("Burto");
        System.out.println("value get: " + valueGet);

        map.remove("Burto");
        ifExist = map.containsKey("Burto");
        System.out.println("Burto exist after removed: " + ifExist);


        String test1 = "Burto";
        String test2 = "Burto";

        System.out.println(test1 == test2);
        System.out.println(test1.equals(test2));

        map.put("Burto", "My name is Burto He new");
        System.out.println("Burto exist after removed: " + map.containsKey(test1));
        System.out.println("Burto exist after removed: " + map.containsKey(test2));


        HashMap<Integer, String> map2 = new HashMap<>();

        Integer integertest1 = 1234567;
        Integer integertest2 = 1234567;

        System.out.println(integertest1 == integertest2);
        System.out.println(integertest1.equals(integertest2));

        int inttest1 = 1234567;
        int inttest2 = 1234567;

        System.out.println(inttest1 == inttest2);
//        System.out.println(inttest1.equals(inttest2));

        // as long as value is the same, no matter what memory location is, map will return that key,value pair
        map2.put(1234567, "My name is Burto He new");
        // Integer Double Flo String Char, all pass by value not reference
        System.out.println("Burto exist after removed: " + map.containsKey(test1));
        System.out.println("Burto exist after removed: " + map.containsKey(test2));

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map3 = new HashMap<>();
        map3.put(node1, "My name is Burto He new");
        // this will check if the memory location have that key, it passes by reference (Customize Class/Object)
        System.out.println("Node1 exist after removed: " + map3.containsKey(node1));
        System.out.println("Node2 exist after removed: " + map3.containsKey(node2));


        // In hashmap

        /*
            - if hashmap is HashMap<String, String>, the space of hashmap use is all strings, content of all string

            - if hashmap is HashMap<Node, Node>, the space of hashmap use is 2 memory addresses of node; 8 bytes + 8 bytes = 16; 1 bytes = 8 bits, Each bit is a binary digit — either 0 or 1.
                - 8 bytes can store up to 2^64 possible values

         */

        /*
            - TreeMap always O(logN)
         */
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "I am 3");
        treeMap.put(0, "I am 0");
        treeMap.put(7, "I am 7");
        treeMap.put(2, "I am 2");
        treeMap.put(5, "I am 5");
        treeMap.put(9, "I am 9");

        System.out.println("3 in treeMap exist: " + treeMap.containsKey(3));
        System.out.println("6 in treeMap exist: " + treeMap.containsKey(6));
        System.out.println(treeMap.get(3));
        treeMap.put(3, "he is 3");
        System.out.println(treeMap.get(3));
        treeMap.remove(3);
        System.out.println("3 in treeMap exist: " + treeMap.containsKey(3));
        System.out.println(treeMap.get(3));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.lastEntry());

        // <=5, key close to 5
        System.out.println(treeMap.floorKey(5)); // 5
        // <=6, key close to 6
        System.out.println(treeMap.floorKey(6)); // 5

        // >=5, key close to 5
        System.out.println(treeMap.ceilingKey(5)); // 5
        // >=6, key close to 5
        System.out.println(treeMap.ceilingKey(6)); // 7

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        TreeMap<Node, String> treeMap2 = new TreeMap<>();
        // class HashMap.Code01_HashMapBasic$Node cannot be cast to class java.lang.Comparable (HashMap.Code01_HashMapBasic$Node is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        // : implements Comparable<Node>; @Override public int compareTo(Node other)
        treeMap2.put(node3, "i am node3");
        treeMap2.put(node4, "i am node4");




        /*
                - When to Use LinkedHashMap
                    - When you want predictable iteration order (the same as insertion).

                    - When order matters (e.g., history, ordered configuration, etc.).

         */
        Map<String, Integer> balance = new LinkedHashMap<>();



    }
}
