package algorithm_1_starter._05_class05;


// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code03_BitAddMinusMultiDiv {


    public static int add(int a, int b) {
        /*
            int a = 46
            int b = 20
            int c = a + b = 66

            int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0

            int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0


                int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0
                                                 ^
                int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0

                                                   00000 1 1 1 0 1 0 ( a^b is : no carry-out addition)
         */

        /*
            int a = 46
            int b = 20
            int c = a + b = 66

            int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0

            int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0


                int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0
                                                 &
                int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0

                                                   00000 0 0 0 1 0 0 ( (a&b) is : carry-out location information)

                                                   00000 0 0 1 0 0 0 ( (a & b) << 1 is : carry-out information)
         */

        /*
            int a = 46
            int b = 20
            int c = a + b = 66

            int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0

            int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0


                int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0
                                                  ^
                int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0

                                                   00000 0 0 0 1 0 0 ( (a&b) is : carry-out location information)

                                                   00000 1 1 1 0 1 0 ( (a^b) is : no carry-out addition)
                                                   00000 0 0 1 0 0 0 ( (a & b) << 1) is : carry-out information)
                                                                     (no carryout addition + carryout information)
                                                                     ( (a^b) + ((a & b) << 1) is : a,b addition)
         */

        /*
            int a = 46
            int b = 20
            int c = a + b = 66

            int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0

            int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0

                int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0
                int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0
                                                  ^
                int a^b                         == 00000 1 1 1 0 1 0

                int a = 46:  32 + 14(8+4+2) + 0 == 00000 1 0 1 1 1 0
                int b = 20:  16 + 4 + 0         == 00000 0 1 0 1 0 0
                                                  &
                int a&b                         == 00000 0 0 0 1 0 0
                int 1<<(a&b)                    == 00000 0 0 1 0 0 0

                a+b = a` + b`
                int a` = (a^b):                00000 1 1 1 0 1 0
                                              ^
                int b` = 1<<(a&b):             00000 0 0 1 0 0 0
                int a'' = (a` ^ b`)     =>     00000 1 1 0 0 1 0

                int a` = (a^b):                00000 1 1 1 0 1 0
                                              &
                int b` = 1<<(a&b):             00000 0 0 1 0 0 0
                          (a` & b`)     =>     00000 0 0 1 0 0 0
                int b`` = 1<<(a`&b`):          00000 0 1 0 0 0 0

                .......................

                a````                          0000010
                b````                          1000000
                                            ^  1000010
                                            &  0000000
                                         1<<&  0000000


                (stop when b``(carry out information == 0 ))

         */


        int sum = a;
        while (b != 0) {
            sum = a ^ b; // no carryout addition
            b = (a & b) << 1; // carryout information:  b -> b` (carryout information)
            a = sum;  // sum = a ^ b -> a`
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    /*
                  a: 0 1 1 0 1 1 1
                * b: 0 0 1 1 0 1 0
               -----------------------
                     0 0 0 0 0 0 0
                   0 1 1 0 1 1 1(0)
                 0 0 0 0 0 0 0
               0 1 1 0 1 1 1(0)(0)(0)
                .....
           0 0 0 0 0 0 0
         0 0 0 0 0 0 0

        Step1:
           a: 0110
         * b: 10111
                  -

         ans: 0110

        Step2:
           a: 0110(0)
         * b: 10111
                 -

         ans: 0110 + 01100

        Step3:
           a: 0110(0)(0)
         * b: 10111
                -

         ans: 0110 + 01100 + 011000

        Step4:
           a: 0110(0)(0)(0)
         * b: 10111
               -

         ans: 0110 + 01100 + 011000 + 0

        Step5:
           a: 0110(0)(0)(0)(0)
         * b: 10111
              -

         ans: 0110 + 01100 + 011000 + 0 + 01100000
     */

    public static int multi(int a, int b) {
        int res = 0;
        // at the start b == 0, return 0 directly
        while (b != 0) {
            // check if the 0 index is 1 or not, if yes, add it into result with 0
            /*
                 a: 0110           b:0101
                 b: 0101         & 1:0001
                                     0001

                 ans: 0110
             */
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            /*
                 a: 0110 0
                 b: 0101


                 ans: 0110
             */
            a <<= 1;
            /*
                 a: 0110 0
                 b: 0101 -> 010 (no sign movement)


                 ans: 0110
             */
            b >>>= 1;
        }
        return res;
    }

        /*
            a: 1111111111111101 (-3)
            b: 1111111111111100 (-4)

            1111111111111010
            1111111111110100
            1111111111101000
            1111111111010000
            1111111110100000
            1111111101000000....


             0000000000000000
            +1111111111110100
            +1111111111101000
            +1111111111010000
            +1111111110100000
            +1111111101000000....
            => 0000000000001100
          */
    public static boolean isNeg(int n) {
        return n < 0;
    }

    /*
         a: 0 1 1 0 1 1 0 0
         b: 0 0 0 0 1 1 0 0

        b`: 0 1 1 0 0 0 0 0 (b move left to close to a)
                -
      a-b`: 0 0 0 0 1 1 0 0

       b``: 0 0 0 0 1 1 0 0 (b` move left to close to a)
                      -
      / =>:     1     1
      / =>: 0 0 1 0 0 1 0 0

     */

    /*
         a  /   b       =   c
         ?   00110        01100

         a = 2^3 * b + 2^2 *b, because b * c = b * 2^3 + b * 2^2 = b*8+b*4

         a/   b     =     c
            01100        01110

         a = b * 2^1 + b * 2^2 + b * 2^3

         c    =  a - 2^(close to a location)
         a`   =  a - 2^(close to a location)
         c    =  c - a`
         a``  =  a` - 2^ (close to next a` location) ....


          a = 2^3 * b + 2^2 *b, because b * c = b * 2^3 + b * 2^2 = b*8+b*4
          a = b * 2^3  + b * 2^2 = b << 3 + b << 2

          c = , a >= 2^? * b, ? =7, then location of that bit in c is 1, and a` = a - 2^7 * b
                location of bit 7 is 1;  x1xxxxxxxx
              next, a` >= 2^? * b, ? =5, then location of that bit in c is 1 and a`` = ` - 2^7 * b
                location of bit 7 is 1;  x1xx1xxxxx

          ......
     */

    public static int div(int dividend, int divisor) {
        // convert a,b to positive
        int x = isNeg(dividend) ? negNum(dividend) : dividend;
        int y = isNeg(divisor) ? negNum(divisor) : divisor;
        int res = 0;

        /*
            x / y, we convert x >= y move left  to y <= x move right,
            because if we move y to left, y might be at sign position MSB, we need to wait when y > x, but at that moment, y might be at signed position, overflowed
            e.g.
                x,positive,             0110....0
                y,positive, will be     1100....0 -> negative

         */

        // location 31, is signed MSB
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            // start from 30, so it start from 0 then increasing, until x >= y, then we found the most closed to x location
            /*
                e.g.
                    x:  000 10 0000 (from x move right, we need to move 3 times to make x > y)
                    y:  000 00 0011 (from y move left, we need to move 4 times to know when y > x, but we need the go back 1 location, result is 4-1 => 3)
             */
            /*
                e.g. 27 / 7
                 a: 010110
                 b: 000111

                 - i = 1, x >> i >= y
                                                a: 010110
                       - b` (first b left move 1): 001110  =>  a:  001000
                 - i = 0 , x>> i >= y
                                                a: 001000
                        b`` (first b left move 0): 000111  =>  a:  001000


             */
            if ((x >> i) >= y) {
                // set the found location bit to 1;
                res |= (1 << i);
                // update x value with x - y << (that found closed bit location)
                x = minus(x, y << i);
            }
        }
        /*
                e.g. -18 / 3 is equal to 18 / 3 = 6, but give 6 with negative sign
                     -18 / -3 is equal to 18 / 3 = 6, but give 6 with positive sign


         */
        // isNeg(a) return 0 or 1, isNeg(a) ^ isNeg(b) is to check if a,b have the same signed
        // 10,01 => 1; 00,11 => 0, same signed => 0, different sign => 1,

//        return isNeg(a) != isNeg(b) ? negNum(res) : res;
        return isNeg(dividend) ^ isNeg(divisor) ? negNum(res) : res;

        /*
            a=9, b=4, a/b, 9 / 4

            a: 01001
            b: 00100

            i = 1

            a`: 0001


         */
    }

    /*
        Take two’s complement of B (i.e. -B)
               000100011   (35)
            +  111101000  (-24)
            -------------
              000001011   (11, carry-out is discarded)
     */



    public static int divide(int dividend, int divisor) {
        // Problem: there is no value for |Integer.MIN_VALUE|, so we need to convert Integer.MIN_VALUE to (Integer.MIN_VALUE + 1) to find the result

        /*
            condition 1: dividend == Integer.MIN_VALUE; divisor == Integer.MIN_VALUE
                         dividend / divisor = 1;
        */
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        /*
            condition 2: dividend != Integer.MIN_VALUE; divisor = Integer.MIN_VALUE
                         ? / Integer.MIN_VALUE = 0;
        */
        else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        /*
            condition 3: dividend == Integer.MIN_VALUE; divisor != Integer.MIN_VALUE
                         condition 3.1: dividend == Integer.MIN_VALUE; divisor == 1
                         condition 3.2: dividend == Integer.MIN_VALUE; divisor != 1
        */
        else if (dividend == Integer.MIN_VALUE) {
            /*
                 condition 3.1: dividend == Integer.MIN_VALUE; divisor == 1
                    return |Integer.MIN_VALUE| = Integer.MAX_VALUE + 1
                    , but in java system does not have Integer.MAX_VALUE + 1, so we only return Integer.MAX_VALUE
             */
            if (divisor == negNum(1)) {
                return Integer.MAX_VALUE;
            }
             /*
                 condition 3.2: dividend == Integer.MIN_VALUE; divisor != 1
                    steps:
                        c = (dividend + 1) / divisor
                        diff = dividend - (c * divisor)
                        c` = diff / divisor
                        result = c + c`
                        (here, all divide is all inside system value range)

             */
            else {
                int c = div(add(dividend, 1), divisor);
                return add(c, div(minus(dividend, multi(c, divisor)), divisor));


                /*
                         -20 / 5 =  [ (-19) / 5 ] + [ [(-20) - (-19 / 5) * (5)] / 5 ]
                                 =  [ (-19) / 5 ] + [ [ -20 + 19 ] / 5 ]
                                 =  [ (-19) / 5 ] + [  -1  / 5 ]
                                 =  [ ( -19 - 1 ) / 5 ]
                                 =  -20 / 5
                                 = (-19 / 5) + (-1 / 5)
                 */

//                int first = add(dividend,1);
//                int c_first = div(first, divisor);
//                int d = multi(c_first, divisor);
//                int diff = minus(dividend, d);
//                int c_second = div(diff , d);
//                int result = add(c_first,c_second);
//                return  result;

//                int first = add(dividend,1);
//                int c_first = div(first, divisor);
//                int c_second = div(-1 , divisor);
//                int result = add(c_first,c_second);
//                return  result;
            }

        }
        /*
            condition 4: dividend != Integer.MIN_VALUE; divisor != Integer.MIN_VALUE
                         ? / ? = normal div(dividend, divisor);
        */
        else {
            return div(dividend, divisor);
        }
    }

    public static void main(String [] args)
    {
        System.out.println(multi(-3,-4));
        System.out.println(negNum(Integer.MIN_VALUE));
        System.out.println(divide(Integer.MIN_VALUE,Integer.MIN_VALUE +1));
        System.out.println(divide(-10,5));
        System.out.println(divide(Integer.MAX_VALUE,Integer.MIN_VALUE));
        System.out.println(divide(Integer.MAX_VALUE,Integer.MIN_VALUE + 1));
        System.out.println(divide(Integer.MAX_VALUE, 5));
    }



}
