package algorithm_1_starter._00_class01;

import java.util.Arrays;

public class Code04_SelectionSort {
    public static void selectionSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;

        // 0 ~ N -1
        // 1 ~ N -1
        // 2 ~ N -1
        for(int cur =0; cur < arr.length - 1; cur++)
        {
            /*
                cur start at 0 index, and loop through all indexes except last indexed, because at the n - 2 round, the last index will be sorted
             */
            int minIndex = cur;
            for (int comparedIndex = cur + 1; comparedIndex < arr.length; comparedIndex++)
            {
                /*
                    comparedIndex related to cur + 1 when initial, loop through all indexes to the end
                 */

                minIndex = arr[comparedIndex] < arr[minIndex] ? comparedIndex : minIndex;
            }
            swap(arr, cur , minIndex);
        }

    }

    public static void swap(int [] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
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

        selectionSort(arr);
        comparator(arrCopy);

        if (isEqual(arr, arrCopy)) {
            System.out.println("Selection sort works correctly!");
        } else {
            System.out.println("Selection sort failed.");
        }

        printArray(arr);
    }
}
