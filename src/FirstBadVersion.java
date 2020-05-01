/** https://leetcode.com/problems/first-bad-version/ */
public class FirstBadVersion {
    /** Method to find first bad version */
    public int firstBadVersion(int n) {
        return firstBadVersionHelper(1, n);
    }

    /** Helper Method */
    /** Approach :: Find Mid element of the array/list available.
     * If Mid is a bad version, then we have a bad version prior to mid or May be mid is the first bad version. So, change end to mid.
     * If Mid is not a bad version, then we may have a bad version after mid. So, then Change start to Mid + 1 index.
     * */
    public int firstBadVersionHelper(int start, int end) {
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                return firstBadVersionHelper(start, mid);
            } else {
                return firstBadVersionHelper(mid + 1, end);
            }
        }
        return start;
    }
}
