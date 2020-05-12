package arrays;

/** https://leetcode.com/problems/single-element-in-a-sorted-array/ */
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));

        int[] nums2 = {1,1,3,3,4,4,8,8,9};
        System.out.println(singleNonDuplicate(nums2));
    }

    /** Approach - 1 :: Iterate over every alternate element and check if it is same as next element or not.
     * If not same, first element is our target. If we reached end, then last element is our target.
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 40.1 MB, less than 8.00% of Java online submissions.
     * */
    public static int singleNonDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i = i+2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
