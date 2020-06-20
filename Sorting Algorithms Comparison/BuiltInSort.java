import java.util.Arrays;

public class BuiltInSort {

    private int[] arr;
    private long duration;

    public BuiltInSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {

        long startTime = System.currentTimeMillis();

        Arrays.sort(arr);

        long endTime = System.currentTimeMillis();

        duration = endTime - startTime;

    }

    public void result() {
        System.out.println("Built in sort -  " + duration + " milliseconds");
    }
}