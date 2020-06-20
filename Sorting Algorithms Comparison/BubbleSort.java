public class BubbleSort {

    private int[] arr;
    private long duration;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
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
        System.out.println("Bubble Sort - \t " + duration + " milliseconds");
    }
}