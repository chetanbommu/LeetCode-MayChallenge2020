public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return firstBadVersionHelper(1, n);
    }

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

    public boolean isBadVersion(int n) {
        return false;
    }
}
