import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4,6,0,1,2,5,9,7,3,8};
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        int[] array2 = {9, 99, 9, 0, 3};

        System.out.println(Arrays.toString(mergeSort(array)));
        System.out.println(Arrays.toString(mergeSort(array1)));
        System.out.println(Arrays.toString(mergeSort(array2)));

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

            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            while (left.length > i && right.length > j) {
                if (left[i] > right[j]){
                    array[k] = right[j];
                    j++;
                } else {
                    array[k] = left[i];
                    i ++;
                }
                k++;
            }

            while (left.length > i){
                array[k] = left[i];
                i++;
                k++;
            }

            while (right.length > j){
                array[k] = right[j];
                j++;
                k++;
            }
        }
        return array;
    }
}

// Time Complexity: O(N log(N))
// Auxiliary Space: O(n)