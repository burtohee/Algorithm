

package BinarySearch;


public class Code04_BSAwesome {

    /*
        BS need sorted array most time, like find index of element,

        -- Partial minimum question, array of elements can be negative/positive/zero; condition: the two closed elements can not be equal, ab; a != b; this question relates to math on increasing or decreasing: first derivative f'(x)
        But when dealing with partial minimum question, BS can solve it, with unsorted array but, condition: the two closed elements can not be equal, abc; a != b != c
     */

    public static int binarySearch(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) /2;

            if(arr[mid] == target)
                return mid;

            if(arr[mid] > target )
                right = mid -1;
            else
                left = mid +1;
        }


        return -1;
    }

    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1; // not found
    }

    // Comparator: sorts array using Java's built-in sort
    public static int comparator(int[] arr, int target) {
        return indexOf(arr, target);
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
        int[] arr = {2,5,7,8,9,12};
        int target = 7;

        int bsResult = binarySearch(arr, target);
        int loopSearchResult = comparator(arr, target);

        if (isEqual(bsResult, loopSearchResult)) {
            System.out.println("BS works correctly!");
        } else {
            System.out.println("BS sort failed.");
        }

        printArray(arr);
        System.out.printf("Element %d, found at index: %d\n", target, bsResult);
    }
}
