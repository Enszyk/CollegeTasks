public class QuickSort {

    private int[] arr;
    private long duration;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {

        long startTime = System.currentTimeMillis();
        sortArr(0, arr.length - 1);
        long endTime = System.currentTimeMillis();

        duration = endTime - startTime;
    }

    public void sortArr(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int sortMarker = parts(startIndex, endIndex);
            sortArr(startIndex, sortMarker - 1);
            sortArr(sortMarker + 1, endIndex);

        }
    }

    int parts(int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j] < pivot) {
                swap(++i, j);
            }
        }

        swap(++i, endIndex);
        return i;
    }

    public void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void result() {

        System.out.println("QuickSort - \t " + duration + " milliseconds");
    }
}