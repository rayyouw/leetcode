class Solution {
    public int getKth(int lo, int hi, int k) {
        int[] arr = new int[hi-lo + 1];
        for(int i = 0; i < hi-lo+1; i++){
            arr[i] = lo + i;
        }

        mergeSort(arr, 0, hi-lo);
        return arr[k-1];
    }

    static boolean compare(int a, int b) {
        if (getSteps(a) != getSteps(b)){
            return getSteps(a) < getSteps(b);
        }     
        return a <= b;
    }
    public static int getSteps(int n){
        if(n == 1){
            return 0;
        }

        if(n % 2 == 0){
            return 1 + getSteps(n/2);
        }else{
            return 1 + getSteps(3 * n + 1);
        }
    }

    static void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (compare(L[i], R[j])) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}