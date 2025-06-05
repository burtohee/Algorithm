package Sorting;

public class BubbleSortHelper extends Code02_BubbleSort {
    public static void callBubbleSort(int[] arr) {
        bubbleSort(arr); // legal because it's protected and we're in a subclass
    }

    public static void callComparator(int[] arr) {
        comparator(arr); // already public, but re-wrapping for consistency
    }

    public static boolean callIsEqual(int[] a, int[] b) {
        return isEqual(a, b); // already public
    }

    public static void callPrintArray(int[] arr) {
        printArray(arr); // already public
    }
}
