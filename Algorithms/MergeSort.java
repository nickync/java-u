import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4,6,0,1,2,5,9,7,3,8};
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        int[] array2 = {9, 99, 9, 0, 3};

        mergeSort(array);

    }

    public static int[] mergeSort(int[] array){

        int mid = array.length / 2;

        if (array.length > 1) {
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            for (int i=0; i<mid; i++){
                left[i] = array[i];
            }

            for (int i=mid; i< array.length; i++){
                right[i-mid] = array[i];
            }

            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
            mergeSort(left);
            mergeSort(right);
        }
        return null;
    }
}
