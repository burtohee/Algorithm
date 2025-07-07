
package algorithm_1_starter._03_class03;


public class Code02_BSNearLeft {

    // in a sorted array, find the index of most left position which >= target

    /*
        BS need sorted array most time, like find index of element,

        -- Partial minimum question, array of elements can be negative/positive/zero; condition: the two closed elements can not be equal, ab; a != b; this question relates to math on increasing or decreasing: first derivative f'(x)
        But when dealing with partial minimum question, BS can solve it, with unsorted array but, condition: the two closed elements can not be equal, abc; a != b != c
     */

    public static int binarySearchNearLeft(int[] sortedArr, int target)
    {
        if(sortedArr == null || sortedArr.length == 0)
            return -1;

        int left = 0;
        int right = sortedArr.length - 1;
        int nearLeftIndex  = -1;

        // L ... R; at least one number, to use binary split
        while (left <= right)
        {
//            int mid = left + (right - left) / 2;
            int mid = left + ((right - left) >> 1);
            if(sortedArr[mid] >= target )
            {
                nearLeftIndex = mid;
                right = mid -1;
            }
            else
                left = mid +1;
        }

        return nearLeftIndex;
    }

    public static int findNearLeft(int[] sortedArr, int target) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= target) return i;
        }
        return -1; // not found
    }

    // Comparator: sorts array using Java's built-in sort
    public static int comparator(int[] arr, int target) {
        return findNearLeft(arr, target);
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
        int[] sortedArr = {1,2,3,3,3,3,4,5,5,6,7,8,9,9,9};
//        int[] sortedArr = {1,2,2,4};
        int target = 3;

        int bsNearLeftResult = binarySearchNearLeft(sortedArr, target);
        int loopSearchResult = comparator(sortedArr, target);

        if (isEqual(bsNearLeftResult, loopSearchResult)) {
            System.out.println("BSNearLeft works correctly!");
        } else {
            System.out.println("BSNearLeft sort failed.");
        }

        printArray(sortedArr);
        System.out.printf("Target %d, <= near left found at index: %d\n", target, bsNearLeftResult);
    }
}
