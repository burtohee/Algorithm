package Sorting;

import java.util.Arrays;

public class Code01_SelectionSort {
    public static void selectionSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;

        // 0 ~ N -1
        // 1 ~ N -1
        // 2 ~ N -1
        for(int i =0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i , minIndex);
        }

    }

    public static void swap(int [] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
