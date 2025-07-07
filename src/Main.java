//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import others_1_ds_sorting.Sorting.BubbleSortHelper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7,1,3,5,1,6,8,1,3,5,7,5,6};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        BubbleSortHelper.callBubbleSort(arr);
        BubbleSortHelper.callComparator(arrCopy);

        if (BubbleSortHelper.callIsEqual(arr, arrCopy)) {
            System.out.println("Selection sort works correctly!");
        } else {
            System.out.println("Selection sort failed.");
        }

        BubbleSortHelper.callPrintArray(arr);
    }
}