package others_1_ds_sorting.Sorting;

import java.util.Arrays;

public class Code02_BubbleSort {
    protected static void bubbleSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;

        // 0 ~ N -1
        // 0 ~ N -2
        // 0 ~ N -3
        for(int loopTimes = arr.length - 1; loopTimes > 0; loopTimes--)
//        for(int loopTimes = arr.length - 1; loopTimes >= 0; loopTimes--)
        {
            /*
                loopTimes start at last index because at the first round, the last index will be sorted, last index will be maximum
                , and loop through all index by decreasing to 1, > 0 beacuse in bubble sort, in the last round at 0 index, it is always sorted.
             */

            boolean swapped = false; // to loopTimes the sorting earlier when there is no swap at all
//            System.out.printf("Round: %2d\n" , loopTimes);
            // 0 ~ loopTimes
            // 0 1(second); 1 2(second); 2 3(second); loopTimes-1 loopTimes(second);
            for (int second = 1; second <= loopTimes; second++)
            {
                /*
                    second start at 1 because bubbleSort want to check the index before current index, to avoid out of index, so second will point to first index and loopTimes the loop by point the last unsorted index
                    , and loop through all indexes which is not sorted, the reason is after each round, the last x-th indexes is sorted
                    so, second related to loopTimes
                */


                if(arr[second -1] > arr[second])
                {
                    swap(arr, second - 1 , second);
                    swapped = true;
                }

            }

            if (!swapped)
            {
//                System.out.println("earlier break");
                break;
            }

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
//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = {7,1,3,5,1,6,8,1,3,5,7,5,6};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        bubbleSort(arr);
        comparator(arrCopy);

        if (isEqual(arr, arrCopy)) {
            System.out.println("Bubble sort works correctly!");
        } else {
            System.out.println("Bubble sort failed.");
        }

        printArray(arr);
    }
}
