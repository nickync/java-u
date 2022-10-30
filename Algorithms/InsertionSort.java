import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4,6,0,1,2,5,9,7,3,8};
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        int[] array2 = {9, 99, 9, 0, 3};

        System.out.println(Arrays.toString(insertionSort(array)));
        System.out.println(Arrays.toString(insertionSort(array1)));
        System.out.println(Arrays.toString(insertionSort(array2)));

    }

    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length-1; i ++){
            int temp = 0;
            for (int j = i+1; j > 0; j --){
                if (array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
}
