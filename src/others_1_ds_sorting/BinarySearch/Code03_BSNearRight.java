

package others_1_ds_sorting.BinarySearch;


public class Code03_BSNearRight {

    // in a sorted array, find the index of most right position which <= target

    /*
        BS need sorted array most time, like find index of element,

        -- Partial minimum question, array of elements can be negative/positive/zero; condition: the two closed elements can not be equal, ab; a != b; this question relates to math on increasing or decreasing: first derivative f'(x)
        But when dealing with partial minimum question, BS can solve it, with unsorted array but, condition: the two closed elements can not be equal, abc; a != b != c
     */

    public static int binarySearchNearRight(int[] sortedArr, int target)
    {
        if(sortedArr == null || sortedArr.length == 0)
            return -1;

        int left = 0;
        int right = sortedArr.length - 1;
        int nearRightIndex  = -1;

        // L ... R; at least one number
        while (left <= right)
        {
//            int mid = left + (right - left) / 2;
            int mid = left + ((right - left) >> 1);

            if(sortedArr[mid] <= target )
            {
                nearRightIndex = mid;
                left = mid +1;
            }
            else
                right = mid -1;
        }


        return nearRightIndex;
    }

    public static int findNearRight(int[] sortedArr, int target) {
        for (int i = sortedArr.length - 1; i >= 0; i--) {
            if (sortedArr[i] <= target) return i;
        }
        return -1; // not found
    }

    // Comparator: sorts array using Java's built-in sort
    public static int comparator(int[] arr, int target) {
        return findNearRight(arr, target);
    }

    public static boolean isEqual(int int1, int int2)
    {
        return int1 == int2;
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


    public static void main(String[] arg)
    {
        int[] arr = {1,2,3,3,3,3,4,5,5,6,7,8,9,9,9};
//        int[] arr = {1,2,2,4};
        int target = 9;

        int bsNearRightResult = binarySearchNearRight(arr, target);
        int loopSearchResult = comparator(arr, target);

        if (isEqual(bsNearRightResult, loopSearchResult)) {
            System.out.println("BSNearRight works correctly!");
        } else {
            System.out.println("BSNearRight sort failed.");
        }

        printArray(arr);
        System.out.printf("Target %d, >= near right found at index: %d\n", target, bsNearRightResult);
    }
}
