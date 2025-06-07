package XOROperation;

public class Code01_XORBasicAndSwap {

    // a must be not equal to b
    public static  void swap(int [] arr, int i , int j)
    {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // a can be equal to b
    public static <T extends Number> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // a can be equal to b
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String [] args)
    {
        /*
            - XOR rules: (Carry-Free Addition), same return 0, not same return 1
                1. 0 ^ N = N
                2. N ^ N = 0
                3. a ^ b = b ^ a
                4. (a ^ b) ^ c = a ^ (b ^ c)

                => 5.  ( (a ^ b) ^ c ) ^ d = f = ( (b ^ a) ^ d ) ^ c; so any order of XOR will return same value

                XOR odd number of 1, return 1
                XOR even number of 1, return 0


         */

        int a = 7;
        int b = 9;

        Others.Code01_PrintB.printB(a);
        Others.Code01_PrintB.printB(b);

        System.out.println("=======");
        int c = a ^ b;
        Others.Code01_PrintB.printB(c);
        System.out.println("=======");
    }
}
