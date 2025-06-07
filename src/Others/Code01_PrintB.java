package Others;

public class Code01_PrintB {

    public static void printB(int num)
    {
        /*
            idea: 32 bits in binary is e.g.
                00000000000000000000000000000101

            then to find the 32 bits of int number, we move the value 1 (always 1) to the location of that bit and use & to find its bit value

            if,num & (1 << i), is zero, then return 0, which means that location bit is 0, otherwise return 1 for the location of bit

            more details:
            - to find location of bit 5,

             00101
            &
             10000
            -------
          => 00000 (so location of bit 5 is 0)

            - to find location of bit 3,

             101
            &
             100
            -------
          => 100 (is not equal to zero, so location of bit 3 is 1)

         */

        // int is signed
        for(int i = 31; i>=0; i--)
        {
            System.out.print( (num & (1 << i)) == 0? "0" : "1") ;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // 32 bits
        int num = 5;
        printB(num);
        System.out.println();
        int test1 = 1;
        printB(test1);  // 1
        printB(test1 << 1); // 1 * 2
        printB(test1 << 2); // 1 * 2 * 2
        System.out.println();
        int test2 = 3;
        printB(test2); // 3
        printB(test2 << 1); // 3 * 2
        printB(test2 << 2); // 3 * 2 * 2

        System.out.println();
        int maxInt = Integer.MAX_VALUE;
        // because int has sign, then the MAX_VALUE is 2^31 - 1 ( 0 ~ 2^31 -1 ), the location of 32 bit is for sign
        // if unsigned: 0 ~ 2^32 -1 ; if signed: -2^31 ~ 2^31 -1
        // positive int: 0 0000000000000000000000000000101
        // negative int: 1 (~0000000000000000000000000000101 + 1)
        System.out.println(maxInt);
        printB(maxInt);

        System.out.println();
        int negative1 = -1;
        System.out.println(negative1);
        printB(negative1);
        int positive1 = 1;
        System.out.println(positive1);
        printB(positive1);


        System.out.println();
        int minInt = Integer.MIN_VALUE; // -2^31
        System.out.println(minInt);
        printB(minInt);

        System.out.println();
        int b = 123823138;
        int c = ~b;
        /*
            - negative binary to positive binary:
                - 1001 (-7)
                1. Invert the bits: Change all 0s to 1s and all 1s to 0s in the binary number.                  0110
                2. Add 1: Add 1 to the inverted binary number.                                                  0111
                3. Ignore carry-out: If there's a carry-out from the most significant bit (MSB), discard it.    0111
            - positive binary to negative binary:
                - 0111  (7)
                1. Flip all the bits: 1000
                2. Add 1: 1000 + 1 = 1001 (-7)
         */

        System.out.println(b);
        printB(b);
        System.out.println(c);
        printB(c);


        System.out.println();
        int d = 3;
        int e = 5;
        System.out.println(d);
        System.out.println(e);
        printB(d);
        printB(e);
        System.out.println("===============");
        printB(d | e); // have at least one 1 return 1
        printB(d & e); // both are 1 return 1
        printB(d ^ e); // same return 0, not same return 1

        System.out.println();
        int _1024 = 1024;
        printB(_1024);
        printB(_1024 >> 1);
        printB(_1024 >>> 1);
        System.out.println("===============");
        printB(minInt);
        printB(minInt >> 1);
        printB(minInt >>> 1);

        System.out.println("===============");
        int f= 5;
        int g= -f;
        int h= (~f + 1);
        int i= (~h + 1);

        System.out.println(g);
        System.out.println(h);
        System.out.println(i);



    }

}
