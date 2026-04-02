/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mArr) {
        int n = mArr.length() - 1;
        int l = 0, r = n;
        int mtIndex = 0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(mArr.get(mid) < mArr.get(mid + 1)) {
                l = mid+1;
            } else if(mArr.get(mid) < mArr.get(mid - 1)) {
                r= mid - 1;
            } else {
                mtIndex = mid;
                break;
            }
        }

        if(target > mArr.get(mtIndex)) {
            return -1;
        } else {
            if(mArr.get(mtIndex) == target) {
                return mtIndex;
            }


            l = 0; r = mtIndex;
            while(l<=r) {
                int mid = l + (r-l)/2;

                if(mArr.get(mid) < target) {
                    l = mid + 1;
                } else if(mArr.get(mid) > target) {
                    r = mid -1;
                } else {
                    return mid;
                }
            }

            l = mtIndex + 1; r = n; 
            while(l<=r) {
                int mid = l + (r-l)/2;

                if(mArr.get(mid) < target) {
                    r = mid - 1;
                } else if(mArr.get(mid) > target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}