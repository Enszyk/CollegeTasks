public class InsertionSort {

    private int[] arr;
    private long duration;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int sortMarker = 1;

        long startTime = System.currentTimeMillis();
        
        for (int j = 0; j < arr.length - 1; j++){
            for (int i = sortMarker++; i > 0; i--) {
                if (arr[i] < arr[i - 1])
                    swap(i, i - 1);
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
        System.out.println("Insertion sort - " + duration + " milliseconds");
    }
}