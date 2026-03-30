class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = mutableListOf<Int>()
        val d = ArrayDeque<Int>()


        var l = 0
        var r = 0

        while (r < n) {
            // if(d.isNotEmpty() && nums[d.first()] < nums[r]) {
            //     d.offerFirst(r)
            // }

            while(d.isNotEmpty() && nums[d.last()] < nums[r]) {
                d.removeLast()
            }

            d.offerLast(r)

            if(r >= k - 1) {
                l++;
                result.add(nums[d.first()]);
            }
            if(d.first() < l) {
                d.removeFirst()
            }

            r++;
        }

        return result.toIntArray()
    }
}