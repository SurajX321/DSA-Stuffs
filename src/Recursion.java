import java.util.Arrays;

public class Recursion {
// identify the smaller sub-problem
//     do the recursive work
//     do the self work
// identify the base case and ensure which work to be done first either recursive or self?
    public static int Fibo(int n){
        if (n<2){
            return n;
        }
        return(Fibo(n-1)+Fibo(n-2));
    }
    static int BinarySearch(int[] arr, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int mid=(s+e)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(target<arr[mid]){
            return BinarySearch(arr,target,s,mid-1);
        }
        return BinarySearch(arr, target, mid+1, e);
}
    static boolean LinearSearch(int[] arr, int target, int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || LinearSearch(arr, target, index+1);
    }
    static int LinearSearchIndex(int[] arr, int target, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return LinearSearchIndex(arr, target, index+1);
    }
    static int Factorial(int n){
        if(n<=1){
            return n;
        }
        return n*Factorial(n-1);
}
    static int sumofDigits(int n){
        if (n<=1){
            return n;
        }
        return sumofDigits(n/10)+(n%10);
}
    static int sum=0;
    static int reversal(int n){
        if (n==0){
            return sum;
        }
        int rem=n%10;
        sum=(sum*10)+rem;
        return reversal(n/10);
}
    static boolean sorted(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sorted(arr, index+1);
    }
    static void bubbleSort(int[] arr, int r, int c){
        if (r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubbleSort(arr, r,c+1);
        }
        else{
            bubbleSort(arr,r-1,0);
        }
    }
    static void selectionSort(int[] arr, int r, int c, int max){
        if (r==0){
            return ;
        }
        if(c<r){
            if(arr[c]>arr[max]){
                selectionSort(arr,r,c+1,c);
            }
            else{
                selectionSort(arr, r,c+1, max);
            }
        }
        else{
            int temp=arr[max];
            arr[max]=arr[r-1];
            arr[r-1]=temp;
            selectionSort(arr,r-1,0,0);
        }
    }
    public static void main(String[] args) {
//        int ans=Fibo(7);
//        System.out.println(ans);
          int[] arr={4,3,2,1};
//        System.out.println(BinarySearch(arr, 44,0, arr.length-1));

        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
}
