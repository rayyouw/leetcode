class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
    
        if (nums[0] == 0) return "0";

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    static boolean compare(int a, int b){
        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);

        return str1.compareTo(str2) > 0;
    }

    private void mergeSort(int[] nums, int l, int r){
        if(l < r){
            int m = l + (r-l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = nums[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = nums[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (compare(L[i], R[j])) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}