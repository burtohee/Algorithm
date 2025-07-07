package others_1_ds_sorting.XOROperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code02_XORFindEvenTImesOddTimes {

    /*
        - question: in a array, there is a number has odd occurrence, the other number have even occurrences; "How to find the odd occurrence number?"

        - idea: XOR all number, because that number have odd occurrence, the XOR result will hold the value at the end
     */

    /*
            - XOR rules: (Carry-Free Addition), same return 0, not same return 1
                1. 0 ^ N = N    <====
                2. N ^ N = 0    <====
                3. a ^ b = b ^ a
                4. (a ^ b) ^ c = a ^ (b ^ c)

                => 5.  ( (a ^ b) ^ c ) ^ d = f = ( (b ^ a) ^ d ) ^ c; so any order of XOR will return same value

                XOR odd number of 1, return 1
                XOR even number of 1, return 0

            - to get right most set bit:
                x & ~(x)
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
    
    public static int XORFindTheOnlyOneOddOccurNumberRecord(int [] arr)
    {
        int XOR = 0;
        for (int anInt: arr)
        {
            XOR = XOR ^ anInt;
        }
        return XOR;
    }

    public static int XORFindTheMostRight1(int a)
    {
        /*
            a       = 01101110010000
            ~a      = 10010001101111
            ~a + 1  = 10010001110000
                               -
            a & (~a + 1) == a & (-a)

         */


        // a & (~a + 1) == a & (-a)
//        return a & (~a + 1);
        return a & (-a);
    }

    public static int[] XORFindTwoOddOccurNumberRecord(int [] arr)
    {
        int n = arr.length;

        // Get the XOR of the two numbers we need to find
        int xorVal = 0;
        for (int i = 0; i < n; i++) {
            xorVal = arr[i] ^ xorVal;
        }

//        /*
//            a,b are two different number
//            ero != 0
//            find eor most right 1
//         */
////        int rightOne = xorVal & (~xorVal + 1);
//        int mostRightOne = xorVal & -xorVal;
//        int numerMatchMostRightOne = 0;
//        for(int i =0; i <arr.length; i++)
//        {
//            if ((arr[i] & mostRightOne) !=0)
//            {
//                numerMatchMostRightOne = numerMatchMostRightOne ^ arr[i];
//            }
//        }
//        System.out.println(numerMatchMostRightOne + " " + (xorVal ^ numerMatchMostRightOne) );


        /*
            xor != 0: it means a ^ b != 0, then there is a bits location that is not same, then we find those number at 2 sets, (that bit location is 1 / that bit location is not 1)
                        in the loop, we separate them into 2 set, e.g set1: {a,1,1,}; set2: {b,2,2}
                      , since all other numbers are even appearance, then we will remove them on that set, then we have separated odd appearance a,b into 2 sets.
         */


        // Get its last set bit
//        xorVal = xorVal & (~xorVal + 1);
        xorVal &= -xorVal;
        int[] ans = {0, 0};
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            // If bit is not set, it
            // belongs to first set.
            if ((num & xorVal) == 0) {
                ans[0] ^= num;
            }
            // If bit is set, it
            // belongs to 2nd set.
            else {
                ans[1] ^= num;
            }
        }

        System.out.println("Two odd occurrence numbers are: " + ans[0] + " and " + ans[1]);

//        // Return in decreasing order
//        if (ans[0] < ans[1]) {
//            int temp = ans[0];
//            ans[0] = ans[1];
//            ans[1] = temp;
//        }

        return ans;
    }

    public static int[] SortFindTwoOddOccurNumberRecord(int [] arr)
    {
        Arrays.sort(arr); // Sort in-place

        int n = arr.length;
        int i = 0;
        int count;
        int foundTimes = 0;
        int[] ans = {0, 0};

        while (i < n) {
            count = 1;

            // Count duplicates
            while (i + 1 < n && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            if (count % 2 != 0) {
                ans[foundTimes] = arr[i];
                foundTimes++;
                System.out.println("Odd occurrence: " + arr[i]);
            }

            i++;
        }
        return ans;
    }




    // Comparator: find odd occurrence number by hashmap
    public static int comparator(int[] arr) {
        return hashMapFindTheOddOccurNumberRecord(arr);
    }

    public static int[] comparator2(int[] arr) {
        return SortFindTwoOddOccurNumberRecord(arr);
    }

    public static boolean isEqual(int int1, int int2)
    {
        return int1 == int2;
    }
    public static boolean isEqual(int [] arr1, int [] arr2)
    {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    public static void printB(int num)
    {
        // int is signed
        for(int i = 31; i>=0; i--)
        {
            System.out.print( (num & (1 << i)) == 0? "0" : "1") ;
        }
        System.out.println();
    }

    public static void main(String [] args)
    {
        int[] arr = {3,4,3,4,5,4,4,6,7,7};
        int hashMapResult= comparator(arr);
        int XORResult = XORFindTheOnlyOneOddOccurNumberRecord(arr);

        if (isEqual(hashMapResult, XORResult)) {
            System.out.println("XORFindTheOddOccurNumber works correctly!");
        } else {
            System.out.println("XORFindTheOddOccurNumber sort failed.");
        }

        printArray(arr);
        System.out.printf("Found the odd occurrence number: %d\n", XORResult);


        int test = 7;
        int test2 = -test;
        System.out.println(test);
        System.out.println(test2);
        printB(test);
        printB(test2);
        System.out.println("========");
        // a & (~a + 1 ) == a & (-a)
        test = 7;
        int xORFindTheMostRight1 = XORFindTheMostRight1(test);
        printB(test);
        printB(xORFindTheMostRight1);
        System.out.println("========");

        arr = Arrays.copyOf(new int[] {3,4,3,4,5,4,4,6,7,7}, 10) ;
        int[] resultXORFindTwoOddOccurNumberRecord = XORFindTwoOddOccurNumberRecord(arr);
        int[] resultSortFindTwoOddOccurNumberRecord = comparator2(arr);
        Arrays.sort(resultXORFindTwoOddOccurNumberRecord);
        if (isEqual(resultSortFindTwoOddOccurNumberRecord, resultSortFindTwoOddOccurNumberRecord)) {
            System.out.println("XORFind2OddOccurNumber works correctly!");
        } else {
            System.out.println("XORFind2OddOccurNumber sort failed.");
        }


    }
}
