class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }

    public void mergeSort(int l, int r, int[] nums) {
        if(l>=r) return;
        int m = l + (r-l)/2;
        mergeSort(l, m, nums);
        mergeSort(m+1, r, nums);
        merge(l, r, m, nums);
    }

    public void merge(int l, int r, int m, int[] arr) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] l1 = new int[n1];
        int[] l2 = new int[n2];

        for(int i = 0; i< n1; i++) {
            l1[i] = arr[l + i];
        }

        for(int j = 0; j<n2; j++) {
            l2[j] = arr[m+1+j];
        }

        int k = l;
        int i = 0, j= 0;

        while(i < n1 && j<n2) {
            if(l1[i] <= l2[j]) {
                arr[k] = l1[i];
                i++;
            } else {
                arr[k] = l2[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = l1[i];
            i++;
            k++;
        }
        
        
        while(j < n2) {
            arr[k] = l2[j];
            j++;
            k++;
        }
    }
}