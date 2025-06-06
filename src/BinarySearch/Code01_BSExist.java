package BinarySearch;


public class Code01_BSExist {

    // in a sorted array, find the index of position which == target

    /*
        BS need sorted array most time, like find index of element,

        -- Partial minimum question, array of elements can be negative/positive/zero; condition: the two closed elements can not be equal, ab; a != b; this question relates to math on increasing or decreasing: first derivative f'(x)
        But when dealing with partial minimum question, BS can solve it, with unsorted array but, condition: the two closed elements can not be equal, abc; a != b != c
     */

    public static int binarySearch(int[] sortedArr, int target) {
        if(sortedArr == null || sortedArr.length == 0)
            return -1;

        int left = 0;
        int right = sortedArr.length - 1;

//        // L ... R; at least 1 number, to use binary split
//        while (left <= right) {

        // L ... R; at least 2 number, to use binary split
        while (left < right) {

//            int mid = left + (right - left) / 2;

            int mid = left + ((right - left) >> 1);

            if (sortedArr[mid] == target)
                return mid;

            if (sortedArr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        // L ... R; at least 2 number
        // when escaping while loop, there is still 1 number to be checked
          return sortedArr[left] == target ? left : -1;

//        L ... R; at least 1 number
//        return -1;
    }

    public static boolean binarySearchToBoolean(int[] sortedArr, int target) {
        if(sortedArr == null || sortedArr.length == 0)
            return false;

        int left = 0;
        int right = sortedArr.length - 1;

//        // L ... R; at least 1 number, to use binary split
//        while (left <= right) {

        // L ... R; at least 2 number, to use binary split
        while (left < right) {

//            int mid = left + (right - left) / 2;

            int mid = left + ((right - left) >> 1);

            if (sortedArr[mid] == target)
                return true;

            if (sortedArr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        // L ... R; at least 2 number
        // when escaping while loop, there is still 1 number to be checked
        return sortedArr[left] == target;

//        L ... R; at least 1 number
//        return false;
    }

    public static int indexOf(int[] sortedArr, int target) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] == target) return i;
        }
        return -1; // not found
    }

    public static boolean exist(int[] sortedArr, int target) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] == target) return true;
        }
        return false; // not found
    }

    // Comparator: sorts array using Java's built-in sort
    public static int comparator(int[] sortedArr, int target) {
        return indexOf(sortedArr, target);
    }

    // Comparator: sorts array using Java's built-in sort
    public static boolean comparatorBoolean(int[] sortedArr, int target) {
        return exist(sortedArr, target);
    }

    public static boolean isEqual(int int1, int int2) {
        return int1 == int2;
    }

    public static boolean isEqual(boolean boolean1, boolean boolean2) {
        return boolean1 && boolean2;
    }

    public static void printArray(int[] arr) {
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


    public static void main(String[] arg) {
        int[] sortedArr = {2, 5, 7, 8, 9, 12, 13};
//        int[] sortedArr = {1, 3, 5, 7};
//        int[] sortedArr = {1,2,3,4};
        int target = 7;

        int bsResult = binarySearch(sortedArr, target);
        int loopSearchResult = comparator(sortedArr, target);

        if (isEqual(bsResult, loopSearchResult)) {
            System.out.println("BS works correctly!");
        } else {
            System.out.println("BS sort failed.");
        }

        boolean bsResultBoolean = binarySearchToBoolean(sortedArr, target);
        boolean loopSearchResultBoolean = comparatorBoolean(sortedArr, target);

        if (isEqual(bsResultBoolean, loopSearchResultBoolean)) {
            System.out.println("BS works correctly!");
        } else {
            System.out.println("BS sort failed.");
        }

        printArray(sortedArr);
        System.out.printf("Target %d, found at index: %d\n", target, bsResult);
    }
}
