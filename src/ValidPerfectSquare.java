public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147395600));
    }

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
