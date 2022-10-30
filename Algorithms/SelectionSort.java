import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {4,6,0,1,2,5,9,7,3,8};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length -1; i++){
            int min = array[i];
            int temp = 0;
            for (int j=i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    temp = j;
                }
            }
            array[temp] = array[i];
            array[i] = min;
        }
        return array;
    }
}
