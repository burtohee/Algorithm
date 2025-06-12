package BitMap;

import java.util.HashSet;

public class Code02_BitMap2 {
    /*
            - Key Features of HashSet:
                No duplicates: If you try to add a duplicate, it won’t be added.

                Unordered: Elements are not stored in any specific order.

                Allows null: You can store one null value.

                Fast operations: Add, remove, and contains operations are on average O(1) time.


                add(num), contain(num),
                if integer, int at least 4 bytes

                set.add("apple");
                set.add("banana");
                set.add("apple");  // Duplicate, won't be added

                - if we use hashset, to store 0-31, we at least need 32 * 4 bytes to store them
                    - but with bit map, we could use 32 bits to store 0-31

                    00000000000000000000000000000000

                                              5    0
                                              |    |
                                              v    v
                    00000000000000000000000000100001


                - to store 0-1023, we need length 1024
                    - int [] set; int 32 bits;  1024 / 32 = 32 => array length
                    - int [32] set
                       0        1  .....     31
                      0-31    32-63       992~1023
     */

    // this type is correct
    public static class BitMap {

        // each index can hold 64 numbers, because long is 8 bytes = 64 bits
        /*
                    arr[0]
            63
            63      1      0

                    arr[1]
           127       65     64
            63       1      0

                    arr[2]
           191       65     128
            63       1      0

            arr[10]: 0~639
         */

        /*
            - if negative -10 ~ 10, can be transfer to 0 ~ 20
                0    ~      20
               -10  .....   10

            - if negative -63 ~ 63, can be transfer to 0 ~ 127
                0    ~      20
               -64  .....   64
                    arr[0]
            -1 ...     -63      -64
            63 ...      1        0

                    arr[1]
            64 63   ...    1      0
            63 62   ...    1      0

                    arr[2]
           191       65     128
            63       1      0

            arr[10]: 0~639
         */
        private long[] bits;

        public BitMap(int max) {

            /*
                 >> 6 => / 64

                 (max+64) >> 6 => (max+64) / 64
             */

            /*
                 0 ~ 0 : we need 1 length of array (8bytes, 64 bites)
                 0 ~ 63 : we need 1 length of array (8bytes, 64 bites)
                 0 ~ 64 : we need 2 length of array (8bytes, 64 bites)
                 0 ~ 127 : we need 2 length of array (8bytes, 64 bites)
                 0 ~ 128 : we need 3 length of array (8bytes, 64 bites)
             */

//            bits = new long[(max+64) / 64];
//            bits = new long[(max+64) / 8 * 8];
//            System.out.println(Double.SIZE); // 64 bits
//            System.out.println(Double.BYTES); // 8 bytes
//            bits = new long[(max+64) / 8 * Double.BYTES];
//            bits = new long[(max+64) / Double.SIZE];
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            /*
                    - find the index of array: number / 64

                    - find the position of the number in the array[index]: (1 << (num & 63)) == (1 << (num % 64))
                        - e.g.

                                    64 32 16 8 4 2 1
                                     -  -  - - - - -

                            num:      011 0 110110 == 438
                                            ------           (pick the last 6 bits)
                            num % 64: 000 0 110110 == 54

                            num % 64: equal 0~6 bits , 2^6 = 64

                        - e.g.

                                    64 32 16 8 4 2 1
                                     -  -  - - - - -

                            64:       000 1 000000 == 64
                            num:      011 0 110110 == 438

                            63:       000 0 111111 == 63
                            num & 63: 000 0 110110 == 54
                            num % 64: 000 0 110110 == 54
             */

            /*
                    - 1L: 64 bits 0000....00001
                     - 1L << (num & 63), we move the one to that location of num % 64, which highlight that value
                        - e.g. we want to store 438, ((max + 64) >> 6) == 6, 438 % 64 = 54,  (num % 64) == (num & 63) = 54
                            - arr[6], inside arr[6], we want the location of bit (54) become 1.
                             -  (1L << (num & 63)) == 000....1.......00000;
                                                             54
                             - and then OR with the old values, bits[num >> 6] |= (1L << (num & 63))
             */




//            bits[num >> 6] |= (1 << (num & 63));
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void remove(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }

//    public static  class ObjectSizeAgent {
//        private static Instrumentation instrumentation;
//
//        public static void premain(String agentArgs, Instrumentation inst) {
//            instrumentation = inst;
//        }
//
//        public static long sizeOf(Object obj) {
//            return instrumentation.getObjectSize(obj);
//        }
//    }

    // this type is correct
    public static class BitMapWithInt {

        private int[] bits;

        public BitMapWithInt(int max) {
//            bits = new int[(max + (4*8)) >> 5];
//            System.out.println(bits.length);
            int bitsNeeded = (int)(Math.floor(Math.log(Integer.SIZE) / Math.log(2)));
//            bits = new int[(max + (Integer.BYTES * Byte.SIZE)) >> 5];
            bits = new int[(max + (Integer.BYTES * Byte.SIZE)) >> bitsNeeded];
        }

        public void add(int num) {
            int bitsNeeded = (int)(Math.floor(Math.log(Integer.SIZE) / Math.log(2)));
//            System.out.println(bitsNeeded);
//            bitsNeeded = Integer.toBinaryString(Long.SIZE).length() - 1;
//            System.out.println(bitsNeeded);
            bits[num >> bitsNeeded] |= (int) (1L << (num & ((Integer.BYTES * Byte.SIZE) - 1)));
//            bits[num >> 5] |= (1 << (num & ((4*8) - 1)));
        }

        public void remove(int num) {
            bits[num >> 5] &= (int) ~(1L << (num & (Integer.SIZE - 1)));
//            bits[num >> 5] &= ~(1 << (num & ((4*8) - 1)));
        }

        public boolean contains(int num) {
            return (bits[num >> 5] & (1L << (num & (Integer.SIZE - 1)))) != 0;
//            return (bits[num >> 5] & (1 << (num & ((4*8) - 1)))) != 0;
        }

    }



    public static void testBitMap() {


        System.out.println("测试开始！");

        int maxValue = 200000000;
        BitMap bitMap = new BitMap(maxValue);
        HashSet<Integer> set = new HashSet<>();

        int testTime = 5000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (maxValue +1));
            double decide = Math.random();

            if(decide < (double) 1 /3)
            {
                bitMap.add(num);
                set.add(num);
            }
            else if (decide < (double) 2 /3)
            {
                bitMap.remove(num);
                set.remove(num);
            }
            else {
                if(bitMap.contains(num) != set.contains(num))
                {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for(int num = 0 ; num <= maxValue; num++)
        {
            if(bitMap.contains(num) != set.contains(num))
            {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void testBitMapWithInt() {


        System.out.println("测试开始！");

        int maxValue = 10;
        BitMapWithInt bitMap = new BitMapWithInt(maxValue);
        HashSet<Integer> set = new HashSet<>();

        int testTime = 1000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (maxValue +1));
            double decide = Math.random();

            if(decide < 0.333)
            {
                bitMap.add(num);
                set.add(num);
            }
            else if (decide < 0.666)
            {
                bitMap.remove(num);
                set.remove(num);
            }
            else {
                if(bitMap.contains(num) != set.contains(num))
                {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for(int num = 0 ; num <= maxValue; num++)
        {
            if(bitMap.contains(num) != set.contains(num))
            {
                System.out.println(num + " " + "Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static  void main(String [] args)
    {
        testBitMap();
        testBitMapWithInt();
    }



}
