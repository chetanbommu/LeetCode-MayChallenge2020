
/** https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/ */
public class MajorityElement {

    /** Main Method to Test the code*/
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    /** Approach : Boyre-Moore Voting Algorithm
     * Initially assign the starting number as a Potential Candidate. Maintain the count of occurrences of candidate.
     * For every number check if it is the potential candidate, If so Increment count else decrement count.
     * If a number appears more than half, then count should be positive.
     * Once we have a candidate with this after Iterating through the loop. Next Loop over and verify if candidate appears more than half times.
     *
     * LeetCode stats:
     * Runtime: 1 ms, faster than 99.86% of Java online submissions.
     * Memory Usage: 43.2 MB, less than 12.50% of Java online submissions.
     * */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;
        for(int i: nums) {
            if(count == 0) {
                candidate = i;
            }
            count += candidate == i? 1 : -1;
        }

        count = 0;
        for(int i: nums) {
            if(i == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : null;
    }
}
