package XOROperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code02_XORFindTheOddOccurNumber {

    /*
        - question: in a array, there is a number has odd occurrence, the other number have even occurrences; "How to find the odd occurrence number?"

        - idea: XOR all number, because that number have odd occurrence, the XOR result will hold the value at the end
     */

    public static void printHashMap(Map<String, Integer> map)
    {
        // HashMap<String, Integer> map: {1=1, 2=2, 4=2}
        // map.entrySet(): [1=1, 2=2, 4=2]
        // Map.Entry<String, Integer> entry: 1=2
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            // entry.getKey() ; entry.getValue()
            System.out.println("Value: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public static Map.Entry<String, Integer> findOddOccurrenceNumber(Map<String, Integer> map)
    {
//        Map.Entry<String, Integer> result = null;
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() % 2 != 0)
            {
                System.out.println("Odd occurrence: " + entry.getKey());
                return entry;
            }
//                break; // stop after finding the first/only one
        }
        return  null;
    }

    public static int hashMapFindTheOddOccurNumberRecord(int [] arr)
    {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        for(int anInt : arr)
        {
            String anIntStr = String.valueOf(anInt);
            map.put(anIntStr, map.getOrDefault(anIntStr, 0) +1 );
        }
        printHashMap(map);

        Map.Entry<String, Integer> resultEntry = findOddOccurrenceNumber(map);
        return Integer.parseInt(resultEntry.getKey());
    }
    
    public static int XORFindTheOddOccurNumberRecord(int [] arr)
    {
        int XOR = 0;
        for (int anInt: arr)
        {
            XOR = XOR ^ anInt;
        }
        return XOR;
    }

    // Comparator: sorts array using Java's built-in sort
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqual(int int1, int int2)
    {
        return int1 == int2;
    }
    public static void printArray(int [] arr)
    {
//        for(int i =0; i < arr.length; i++)
//        {
//            System.out.print(arr[i] + " ");
//        }
        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String [] args)
    {
        int[] arr = {1,2,2,4,4};
        int hashMapResult= hashMapFindTheOddOccurNumberRecord(arr);
        int XORResult = XORFindTheOddOccurNumberRecord(arr);

        if (isEqual(hashMapResult, XORResult)) {
            System.out.println("XORFindTheOddOccurNumber works correctly!");
        } else {
            System.out.println("XORFindTheOddOccurNumber sort failed.");
        }

        printArray(arr);
        System.out.printf("Found the odd occurrence number: %d\n", XORResult);

    }
}
