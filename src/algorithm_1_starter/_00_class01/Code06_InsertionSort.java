
package algorithm_1_starter._00_class01;

import java.util.Arrays;

public class Code06_InsertionSort {
    public static void insertionSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;

        // 0 ~ 0
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ n-1
        for(int cur = 1; cur < arr.length; cur++)
        {
            /*
                cur start at 1 index, because insertionSort always check values on the left
                , cur loop through all index to last index
             */

//            while(cur-1 >= 0 && arr[cur - 1] > arr[cur])
//            {
//                swap(arr, cur, cur - 1);
//                cur--;
//            }

            for(int pre = cur - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--)
            {
                /*
                    pre start at left side of cur, and compare pre and current(cur)
                    , cur loop through all indexes on the left
                    , loop condition when 1. there is nothing on the left; 2. pre index value (pre) is larger than current index value (pre + 1)
                */
                swap(arr, pre, pre + 1);
            }

//            for(int curDot = cur; curDot > 0 && arr[curDot - 1] > arr[curDot]; curDot--)
//            {
//                /*
//                    pre start at left side of cur, and compare pre and current(cur)
//                    , cur loop through all indexes on the left
//                    , loop condition when 1. there is nothing on the left; 2. pre index value (pre) is larger than current index value (pre + 1)
//                */
//                swap(arr, curDot, curDot - 1);
//            }
        }

    }

    public static void swap(int [] arr, int i, int j)
    {
        // this swap will not work if, i == j
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // Comparator: sorts array using Java's built-in sort
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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


    public static void main(String[] args) {
        int[] arr = {7,1,3,5,1,6,8,1,3,5,7,5,6};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        insertionSort(arr);
        comparator(arrCopy);

        if (isEqual(arr, arrCopy)) {
            System.out.println("Insertion sort works correctly!");
        } else {
            System.out.println("Insertion sort failed.");
        }

        printArray(arr);
    }
}
