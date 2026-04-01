class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;

        while(l<=r) {
            int i = (l + r)/2;
            int j = ((m+n)/2) - i;
            int min1 = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
            int max1 = (i==m) ? Integer.MAX_VALUE : nums1[i];

            int min2 = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
            int max2 = (j==n) ? Integer.MAX_VALUE : nums2[j];

            if(max1 < min2) {
                l = i + 1;
            } else if(max2 < min1) {
                r = i - 1;
            } else {
                if((m + n)%2  != 0) {
                    return (double)Math.min(max1, max2);
                } else {
                    int median1 = Math.max(min1, min2);
                    int median2 = Math.min(max1, max2);
                    return (double)(median1 + median2)/2;
                }
            }

        }
        return 0.0;
    }
}
