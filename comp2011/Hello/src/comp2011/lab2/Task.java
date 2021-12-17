package comp2011.lab2;

import java.security.SecureRandom;
import java.util.Arrays;

public class Task {

    public static void main(String[] args) {

        longTest(32768, SortingType.SELECTION);
//        longTest(32768, SortingType.MINMAXSELECTION);
//        longTest(32768, SortingType.INSERTION);
//        longTest(32768, SortingType.BINARYINSERTION);
//        longTest(32768, SortingType.BUBBLEWITHOUTFLAG);
//        longTest(32768, SortingType.BUBBLESORT);
//
//        longTest(65536, SortingType.SELECTION);
//        longTest(65536, SortingType.MINMAXSELECTION);
//        longTest(65536, SortingType.INSERTION);
//        longTest(65536, SortingType.BINARYINSERTION);
//        longTest(65536, SortingType.BUBBLEWITHOUTFLAG);
//        longTest(65536, SortingType.BUBBLESORT);
//
//
//        longTest(131072, SortingType.SELECTION);
//        longTest(131072, SortingType.MINMAXSELECTION);
//        longTest(131072, SortingType.INSERTION);
//        longTest(131072, SortingType.BINARYINSERTION);
//        longTest(131072, SortingType.BUBBLEWITHOUTFLAG);
//        longTest(131072, SortingType.BUBBLESORT);
//
//
//        longTest(262144, SortingType.SELECTION);
//        longTest(262144, SortingType.MINMAXSELECTION);
//        longTest(262144, SortingType.INSERTION);
//        longTest(262144, SortingType.BINARYINSERTION);
//        longTest(262144, SortingType.BUBBLEWITHOUTFLAG);
//        longTest(262144, SortingType.BUBBLESORT);
//
//
//        longTest(524288, SortingType.SELECTION);
//        longTest(524288, SortingType.MINMAXSELECTION);
//        longTest(524288, SortingType.INSERTION);
//        longTest(524288, SortingType.BINARYINSERTION);
//        longTest(524288, SortingType.BUBBLESORT);
//        longTest(524288, SortingType.BUBBLEWITHOUTFLAG);

    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        int i, j, temp;
        boolean flag = true; //array is not sorted
        for (i = 1; flag && (i < n); i++) {
            flag = false;
            for (j = 0; j < n - i; j++)
                if (a[j + 1] < a[j]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
        }
    }

    public static void bubbleWithoutFlag(int[] a) {
        int n = a.length;
        int i, j, temp;
        for (i = 1; i < n; i++) {
            for (j = 0; j < n - i; j++)
                if (a[j + 1] < a[j]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
        }
    }

    private static void selection(int[] a) {
        int length = a.length;
        int min;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    private static void minMaxSelection(int[] a) {
        int n = a.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int min = i, max = i;
            int maxValue = a[max];
            for (int k = i; k <= j; k++) {
                if (a[k] > a[max]) {
                    maxValue = a[k];
                    max = k;
                } else if (a[k] < a[min])
                    min = k;
            }

            swap(a, i, min);

            if (a[min] == maxValue)
                swap(a, j, min);
            else
                swap(a, j, max);
        }
    }

    private static void insertion(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int key = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] <= key)
                    break; // first part is sorted, if last item in the first part <= current, then current is in the right place.
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    private static void binaryInsertion(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int key = a[i];
            int j = i - 1;
            int loc = binarySearch(a, key, 0, j);
            for (; j >= loc; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    private static int binarySearch(int a[], int key, int low, int high) {
        if (high == low)
            return (key > a[low]) ? (low + 1) : low;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) return mid + 1;
            else if (a[mid] > key) high = mid - 1;
            else if (a[mid] < key) low = mid + 1;
        }

        return low;
    }


    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    private static void duration(int[] a, SortingType sortingType, InputType inputType) {
        long startTime = 0;
        long endTime = 0;
        switch (sortingType) {
            case BUBBLESORT:
                startTime = System.currentTimeMillis();
                bubbleSort(a);
                endTime = System.currentTimeMillis();
                break;
            case BUBBLEWITHOUTFLAG:
                startTime = System.currentTimeMillis();
                bubbleWithoutFlag(a);
                endTime = System.currentTimeMillis();
                break;
            case SELECTION:
                startTime = System.currentTimeMillis();
                selection(a);
                endTime = System.currentTimeMillis();
                break;
            case MINMAXSELECTION:
                startTime = System.currentTimeMillis();
                minMaxSelection(a);
                endTime = System.currentTimeMillis();
                break;
            case INSERTION:
                startTime = System.currentTimeMillis();
                insertion(a);
                endTime = System.currentTimeMillis();
                break;
            case BINARYINSERTION:
                startTime = System.currentTimeMillis();
                binaryInsertion(a);
                endTime = System.currentTimeMillis();
                break;
        }
        long duration = (endTime - startTime);
        System.out.println("runs " + sortingType + " with " + inputType + " input takes " + (duration / 1000.) + " seconds.");
    }

    public static void longTest(int size, SortingType sortingType) {
        System.out.println("input size is: " + size);

        int[] a = randomOrder(size);
//        printArray(a);
        duration(a, sortingType, InputType.RANDOM);
//        printArray(a);

        int[] b = increasingOrder(size);
//        printArray(b);
        duration(b, sortingType, InputType.INCREASING);
//        printArray(b);

        int[] c = decreasingOrder(size);
//        printArray(c);
        duration(c, sortingType, InputType.DECREASING);
//        printArray(c);

    }

    public static int[] randomOrder(int size) {
        int[] a = new int[size];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(size);
        return a;
    }

    public static int[] increasingOrder(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] decreasingOrder(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;
        }
        return a;
    }


}
