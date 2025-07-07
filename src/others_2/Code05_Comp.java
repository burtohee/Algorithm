package others_2;


public class Code05_Comp {

    /*
        return: an array, with length [ 0 , maxLen - 1 ]; values in the array [ 0,maxValue - 1 ];
     */
    public static int[] lenReadonValueRandom(int maxLen, int maxValue)
    {
        int len = (int) (Math.random() * maxLen);
        int [] ans = new int[len];
        for(int i = 0; i < len; i++)
        {
            ans[i] =  (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int [] arr)
    {
        int [] ans = new int[arr.length];
        for(int i = 0; i < ans.length; i++)
        {
            ans[i] = arr[i];
        }
        return ans;

//        return Arrays.copyOf(arr,arr.length);
    }

    public static boolean equalValues(int [] arr1, int [] arr2) {
        for(int i = 0; i < arr1.length; i++)
        {
            if(arr1[i] != arr2[i])
            {
                return false;
            }

        }
        return true;
    }

    public static boolean isSorted(int [] arr)
    {
        if(arr.length < 2)
        {
            return true;
        }
//        for(int i = 0; i < arr1.length; i++)
//        {
//            if(arr1[i] != arr2[i])
//            {
//                return false;
//            }
//
//        }
//        return true;
        int max = arr[0];

//        for(int i = 0; i < arr.length; i++)
//        {
//            if(max > arr[i])
//            {
//                return false;
//            }
//            max = Math.max(max, arr[i]);
//        }

        for (int j : arr) {
            if (max > j) {
                return false;
            }
            max = j;
        }
        return true;
    }

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
        }

    }
    public static void swap(int [] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int [] arr)
    {

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String [] args)
    {
        int maxLen = 10000;
        int maxValue = 10000;
        int testTime = 10000;
        for(int i = 0; i < testTime; i++)
        {
//            ans[i] =  (int) (Math.random() * maxValue);
            int [] arr1 = lenReadonValueRandom(maxLen, maxValue);
            int [] temp1 = copyArray(arr1);
            int [] arr2 = copyArray(arr1);
            int [] temp2 = copyArray(arr2);
            selectionSort(arr1);
            insertionSort(arr2);
            if(equalValues(arr1,arr2))
            {
                System.out.println("selection Sorting works");
            }
            if(isSorted(arr2))
            {
                printArray(temp2);
                System.out.println("Insertion Sorting works");
            }



        }

    }
}
