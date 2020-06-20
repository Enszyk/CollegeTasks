public class SelectSort {

    private int[] arr;
    private long duration;

    public SelectSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int sortMarker = 0;
        int minIndex = 0;

        long startTime = System.currentTimeMillis();

        for (int j = 0; j < arr.length; j++) {
            int minElement = Integer.MAX_VALUE;
            for (int i = sortMarker; i < arr.length; i++) {
                if (arr[i] < minElement) {
                    minElement = arr[i];
                    minIndex = i;
                }
            }
            swap(sortMarker++, minIndex);
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
        System.out.println("Select sort - \t " + duration + " milliseconds");
    }
}