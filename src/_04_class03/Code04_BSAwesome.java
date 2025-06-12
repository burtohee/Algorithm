

package _04_class03;


public class Code04_BSAwesome {

    /*
        BS need sorted array most time, like find index of element,

        -- Partial minimum question, array of elements can be negative/positive/zero; condition: the two closed elements can not be equal, ab; a != b; this question relates to math on increasing or decreasing: first derivative f'(x)
        But when dealing with partial minimum question, BS can solve it, with unsorted array but, condition: the two closed elements can not be equal, abc; a != b != c
     */

    public static int binarySearchAwesome(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }
        int arrLength = arr.length;

        if(arrLength == 1 || arr[0] < arr[1])
            return 0;
        if(arr[arrLength -1] < arr[arrLength - 2])
            return arrLength -1;

        /*
            the binary split from 1 ~ N - 2
         */
        int left = 1;
        int right = arrLength - 2;
        int mid = 0;
        while (left < right)
        {
            mid = left + (right - left) /2;
            System.out.println(left+ " "+mid+ " "+ right);
            if(arr[mid] > arr[mid - 1])
            {
                right = mid -1;
            }
            else if (arr[mid] > arr[mid + 1])
            {
                left = mid +1;
            }
            else if(arr[mid] == arr[mid + 1] && arr[mid] == arr[mid - 1])
            {
                throw new Error("The Error does not match the condition");
            }
            else
            {
                System.out.printf("%d %d %d\n", arr[mid -1 ], arr[mid] ,arr[mid + 1]);
                return mid;
            }


//            if(arr[mid] > arr[mid-1])
//            {
//                right = mid-1;
//            }
//            else if (arr[mid] < arr[mid-1])
//            {
//                left = mid+1;
//            }
//            else {
//                return mid;
//            }
        }
        return left;
    }

    public static int findPartialMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int arrLength = arr.length;

        if(arrLength == 1 || arr[0] < arr[1])
            return 0;
        if(arr[arrLength -1] < arr[arrLength - 2])
            return arrLength -1;

        for (int i = 0; i < arrLength; i++) {
            boolean leftOk = (i == 0) || (arr[i] < arr[i - 1]);
            boolean rightOk = (i == arrLength - 1) || (arr[i] < arr[i + 1]);

            if (leftOk && rightOk) {
                return arr[i];
            }
        }

        throw new RuntimeException("No partial minimum found");
    }

    // Comparator: sorts array using Java's built-in sort
    public static int comparator(int[] arr) {
        return findPartialMin(arr);
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
        int[] arr = {5, 1, 4, 2 , 3, 8};

        int bsAwesomeResult = binarySearchAwesome(arr);
        System.out.println(bsAwesomeResult);
        int loopSearchResult = comparator(arr);

        if (isEqual(bsAwesomeResult, loopSearchResult)) {
            System.out.println("BS works correctly!");
        } else {
            System.out.println("BS sort failed.");
        }

        printArray(arr);
        System.out.printf("Found one Partial minimum at index: %d\n", bsAwesomeResult);
    }
}
