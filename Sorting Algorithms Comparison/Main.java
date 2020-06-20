public class Main {

    public static void main(String[] args) {

        Generate genarator = new Generate(40000);

        int[] arr = genarator.generateAscending(100);
        int[] arr2 = genarator.generateShuffle();
        int[] arr3 = genarator.generateDescending();

        System.out.println("\n\n\nPosortowane losowo \n\n");

        BubbleSort bubbleSA = new BubbleSort(arr2.clone());
        InsertionSort insertionSA = new InsertionSort(arr2.clone());
        BuiltInSort buildInSA = new BuiltInSort(arr2.clone());
        SelectSort selectSA = new SelectSort(arr2.clone());
        ShellSort shellSA = new ShellSort(arr2.clone());
        QuickSort quickSA = new QuickSort(arr2.clone());

        bubbleSA.sort();
        bubbleSA.result();

        insertionSA.sort();
        insertionSA.result();

        buildInSA.sort();
        buildInSA.result();

        selectSA.sort();
        selectSA.result();

        shellSA.sort();
        shellSA.result();

        quickSA.sort();
        quickSA.result();

        System.out.println("\n\nPosortowane wzglednie rosnaco\n\n");

        BubbleSort bubbleS = new BubbleSort(arr.clone());
        InsertionSort insertionS = new InsertionSort(arr.clone());
        BuiltInSort buildInS = new BuiltInSort(arr.clone());
        SelectSort selectS = new SelectSort(arr.clone());
        ShellSort shellS = new ShellSort(arr.clone());
        QuickSort quickS = new QuickSort(arr.clone());

        bubbleS.sort();
        bubbleS.result();

        insertionS.sort();
        insertionS.result();

        buildInS.sort();
        buildInS.result();

        selectS.sort();
        selectS.result();

        shellS.sort();
        shellS.result();

        quickS.sort();
        quickS.result();

        System.out.println("\n\n");

        System.out.println("\n\n\nPosortowane wzglednie malejaco \n\n");

        BubbleSort bubbleSD = new BubbleSort(arr3.clone());
        InsertionSort insertionSD = new InsertionSort(arr3.clone());
        BuiltInSort buildInSD = new BuiltInSort(arr3.clone());
        SelectSort selectSD = new SelectSort(arr3.clone());
        ShellSort shellSD = new ShellSort(arr3.clone());
        QuickSort quickSD = new QuickSort(arr3.clone());

        bubbleSD.sort();
        bubbleSD.result();

        insertionSD.sort();
        insertionSD.result();

        buildInSD.sort();
        buildInSD.result();

        selectSD.sort();
        selectSD.result();

        shellSD.sort();
        shellSD.result();

        quickSD.sort();
        quickSD.result();

        System.out.println("\n");

    }
}
