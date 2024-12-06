package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrs={1,3,5,2,7};
        quickSort(arrs,0, arrs.length-1);
        System.out.println(Arrays.toString(arrs));
    }

    static void quickSort(int[] arr, int low, int hi){
       if(low>=hi){
           return;
       }
       int s=low;
       int e=hi;
       int mid=s+(e-s)/2;
       int pivot=arr[mid];
       while(s<=e){
            while (arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
       if(low<e) {
           quickSort(arr, low, e);
       }
       if(s<hi) {
           quickSort(arr, s, hi);
       }
    }
}
