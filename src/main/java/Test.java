import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arrayToSort1 = new int[]{9, 6, 1, 100, 3, 7, 2, 10};
        int[] arrayToSort2 = new int[]{9, 6, 1, 100, 3, 7, 2, 10};

        int[] arrayToSort3 = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arrayToSort3.length; i++) {
            arrayToSort3[i] = random.nextInt();
        }

        long timer1 = System.nanoTime();
        System.nanoTime();
        Solution.selectionSort(arrayToSort3);
        long timer2 = System.nanoTime();
        //System.out.println(Arrays.toString(arrayToSort3));
        long res1 = timer2 - timer1;
        System.out.println("Time:" + res1);

        long timer3 = System.nanoTime();
        Solution.quickSort(arrayToSort3, 0, 9999);
        long timer4 = System.nanoTime();
        //System.out.println(Arrays.toString(arrayToSort3));
        long res2 = timer4 - timer3;
        System.out.println("Time:" + res2);


        if (res1 < res2) System.out.println("Сортировка выборкой быстрее.");
        else System.out.println("Быстрая сортировка быстрее.");


    }
}
