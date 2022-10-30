import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {4,6,0,1,2,5,9,7,3,8};
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        int[] array2 = {9, 99, 9, 0, 3};
        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println(Arrays.toString(selectionSort(array1)));
        System.out.println(Arrays.toString(selectionSort(array2)));
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
            if (min != array[i]) {
                array[temp] = array[i];
                array[i] = min;
            }
        }
        return array;
    }
}

//Time Complexity
//Best: ?(n^2)
//Average: ?(n^2)
//Worst: O(n^2)

//Space Complexity
//O(1)
