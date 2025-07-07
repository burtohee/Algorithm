package algorithm_1_starter._08_class08;

public class Code02_MergeSort {

    public static void mergeSort1(int [] arr)
    {
        if(arr == null || arr.length < 2)
        {
            return;
        }
        process(arr, 0,arr.length -1);
    }

    public static void process(int[] arr, int L, int R)
    {
        if(L == R)
        {
            return;
        }
        int mid = L + ((R - L) >> 1);

        process(arr, L, mid);
        process(arr, R, mid);

        merge(arr, L, mid, R);

    }

    public static void merge(int [] arr, int L, int M, int R)
    {

    }

}
