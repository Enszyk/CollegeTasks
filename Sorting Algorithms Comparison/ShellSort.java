import java.lang.Math;

public class ShellSort {

    private int[] arr;
    private long duration;

    public ShellSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int d = 10;
        int i = 1;

        long startTime = System.currentTimeMillis();

        // shell sort
        while (d > 2) {
            d = (int) (arr.length / Math.pow(2, i++));
            int iterator = 0;
            while (iterator + d < arr.length) {
                if (arr[iterator] > arr[iterator + d])
                    swap(iterator, iterator + d);
                iterator++;
            }
        }

        // insertion sort
        int sortMarker = 1;

        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = sortMarker++; k > 0; k--) {
                if (arr[k] < arr[k - 1])
                    swap(k, k - 1);
                else
                    break;
            }

        }

     

        long endTime = System.currentTimeMillis();

        duration = endTime - startTime;

    }

    public void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void result() {
        System.out.println("Shell sort - \t " + duration + " milliseconds");
    }
}