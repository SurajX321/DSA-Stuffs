public class ArrayManipullation {
    public static void main(String[] args) {
        int[] arr={1,1,2,3};
        System.out.println(unique(arr));
    }
    static int unique(int[] arr){
        int n = arr.length;
        if(n==0) return 0;
        int k=0;
        int[] ans=new int[n];
        ans[k++]=arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i]!=arr[i-1]) {
                ans[k++] = arr[i];
            }
        }
        return k;
    }
}
