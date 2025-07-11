package algorithm_1_starter._08_class08;

public class Code02_MergeSort {


    // method 1: recursive
    public static void mergeSort1(int [] arr)
    {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }



//    arr[L..R] range, have all this element in this range sorted
    public static void process(int[] arr, int L, int R)
    {
        if (L == R) {
            return;
        }
        // int mid = (L + R) / 2
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int [] arr, int L, int M, int R)
    {
        int [] help = new int[R - L + 1];

        int i = 0;

        int p1 = L;

        int p2 = M+1;

        // when none of the pointer did not cross Mid/Right
        while(p1 <= M && p2 <= R)
        {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]: arr[p2++];
        }
        while(p1 <=M)
        {
            help[i++] = arr[p1++];
        }
        while(p2 <=R)
        {
            help[i++] = arr[p2++];
        }
        for(i =0; i < help.length; i++)
        {
            arr[L+i] = help[i];
        }



    }

    // method2: non-recursive, main idea is steps.
    public static void mergeSort2(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int step = 1;
        int N = arr.length;

        // break when step equal or larger than length of array
        while (step < N) {

            // first left group
            int L = 0;

            // there is no left group after N length
            while (L < N) {

//                int M = L + step - 1; // incorrect, because left group might be shorted
                /*
                    e.g.
                        0 1 2 3 | 4 5 6 7 |   8
                           L1       R1       L2
                 */
                int M = 0;
//                int M = Math.min(N-1, L + step - 1); // incorrect, N-1 is the last index, L + step - 1 is left group is filled with  steps, L + step -1 might overflow, then its result is negative

//                why N - L? we want to know if (N - 1) - L + 1 have how many steps

                // we have left filled with steps
                // L...M  M+1...R
                if (N - L >= step) {
                    M = L + step - 1;
                }
                // condition when left group can fill steps, so last index will the M
                // L...N-1
                else {
                    M = N - 1;
                }

                // there is no merge, since only 1 left group
                // L...M
                if (M == N - 1) {
                    break;
                }

                // int R = M + 1, incorrect, might overflow again
                int R = 0;

                // why N - L? we want to know if (N - 1) - (M + 1) + 1 => (N - 1 - M) have how many steps for right group
                if (N - 1 - M >= step) {
                    // M+1+step-1....R => M + step
                    R = M + step;
                } else {
                    // N - 1
                    R = N - 1;
                }
                // L...M   M+1...R
                merge(arr, L, M, R);

                // check if right group is at the end, if yes, no further action, if no, move the L pointer to R+1
                if (R == N - 1) {
                    break;
                } else {
                    // next L pointer to R + 1 for L pointer
                    L = R + 1;
                }
            }

            // step to avoid overflow
            // idea is: int max is 2^31 - 1; so maximum step would be 2^30, here step > N / 2, which does not allow step go over 2^30
            if (step > N / 2) {
                break;
            }
            // if only use this, unsafe, might be overflow
            step *= 2;

//            if (step > N / 2) {
//                break;
//            }
//            else
//            {
//                step *= 2;
//            }

        }

    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
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

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }


}
