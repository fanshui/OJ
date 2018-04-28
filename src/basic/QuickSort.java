package basic;

import java.util.Collection;
import java.util.Collections;

public class QuickSort {
    public static void quickSort(int[] arr,int start,int end) {

        /*终止条件*/
        if (start >= end)
            return;

        int i = start ;
        int j = end ;
        int temp = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= temp)
                j --;
            arr[i] = arr[j];

            while (i < j && arr[i] <= temp)
                i ++;
            arr[j] = arr[i];
        }

        arr[i] = temp;
        quickSort(arr,start,i-1);
        quickSort(arr,i + 1,end);

    }

    public static void main(String[] args) {
        int[] array = {10,2,5,4,6,9,8,7,1,3};
        quickSort(array,0,array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
