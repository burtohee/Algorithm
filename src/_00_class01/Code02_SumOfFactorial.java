package _00_class01;

public class Code02_SumOfFactorial {

    public static long factorialWithRecursive(int n) {
        if (n == 0) return 1;
        return n * factorialWithRecursive(n - 1);
    }
    public static long sumOfFactorialsWithRecursive(int n) {
        if (n == 0) return 1; // 0! = 1
        return factorialWithRecursive(n) + sumOfFactorialsWithRecursive(n - 1);
    }

    public static long factorialWithLoop(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long sumOfFactorial (int N)
    {
        long ans = 0;
        long cur = 1;
        for(int i =1; i <= N; i++)
        {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] arg)
    {
        double result = (double) sumOfFactorial(5);
        System.out.printf("N of sum of factorial: %2f", result);
    }

}
