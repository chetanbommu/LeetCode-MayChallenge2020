public class ValidPerfectSquare {

    /** https://leetcode.com/problems/valid-perfect-square/ */
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147395600));
    }

    /** Approach : Using Binary Search to find the square.
     * Low: 0
     * High: 46340 (Max possible square root for Integer.MAX_VALUE)
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 36.4 MB, less than 6.12% of Java online submissions.
     * */
    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = 46340;
        int mid = 0;
        int square = 0;
        while(low <= high) {
            mid = low + (high - low)/2;
            square = mid * mid;
            if(square == num) {
                return true;
            } else if(square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
