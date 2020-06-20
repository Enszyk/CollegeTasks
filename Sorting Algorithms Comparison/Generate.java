import java.util.Random;

public class Generate {

    private int[] arr;
    private int n;

    public Generate(int n) {
        this.n = n;
        arr = new int[n];
    }

    public int[] generateShuffle() {

        int index, temp;
        Random random = new Random();

        int[] arrS = new int[n];
        arrS = arr.clone();

        for (int i = arrS.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = arrS[index];
            arrS[index] = arrS[i];
            arrS[i] = temp;
        }

        return arrS;
    }

    public int[] generateAscending(int k) {

        int min = 0;
        int max = k * 2;

        for (int i = 0; i < n / k; i++) {
            for (int j = 0; j < k; j++)
                arr[j + i * k] = (int) (Math.random() * (max - min)) + min;
            min += k;
            max += k;
        }
        return arr;
    }

    public int[] generateDescending() {

        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++)
            arr2[i] = arr[n - i - 1];

        return arr2;
    }

}