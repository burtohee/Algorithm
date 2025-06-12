package BitMap;

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

                                                   00000 0 0 1 0 0 0 ( 1<<(a&b) is : carry-out information)
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
                                                   00000 0 0 1 0 0 0 ( 1<<(a&b) is : carry-out information)
                                                                     (no carryout addition + carryout information)
                                                                     ( (a^b) + (1<<(a&b)) is : a,b addition)
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
            a = sum;  // a -> a`
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }


}
