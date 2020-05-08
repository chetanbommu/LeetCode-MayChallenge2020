/** https://leetcode.com/problems/check-if-it-is-a-straight-line/ */
public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        int[][] coordinates1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(checkStraightLine(coordinates1));
        System.out.println(checkStraightLine(coordinates2));
    }

    /** Approach - 1 : Using slope.
     * Slope should be same for any two points.
     *
     * LeetCode stats:
     * Runtime: 1 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 39.7 MB, less than 100.00% of Java online submissions
     * */
    public static boolean checkStraightLine(int[][] coordinates) {
        double slope = 0;
        if(coordinates.length < 2) {
            return false;
        }
        else if(coordinates.length == 2) {
            return true;
        }
        if(coordinates[0][0] != coordinates[1][0]){
            slope = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            for(int i = 2; i < coordinates.length; i++) {
                double tempSlope = (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0] * 1.0);
                if(tempSlope != slope) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
