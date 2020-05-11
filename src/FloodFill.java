import java.util.HashSet;
import java.util.Set;

public class FloodFill {

    /** Method to find first bad version */
    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {1,0,0}};
        print(image);
        image = floodFill(image, 1, 0, 2);
        print(image);
    }

    /** Approach - 1 : Go to first point in the matrix check if it is same as new color, if so return as no new changes are needed.
     * If not same, store the previous color, Modify starting pixel to new color.
     * Do a dfs for 4 directionally points for starting point plus any pixels connected 4-directionally to these pixels.
     *
     * LeetCode stats:
     * Runtime: 7 ms, faster than 5.96% of Java online submissions.
     * Memory Usage: 40.8 MB, less than 84.21% of Java online submissions.
     * */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Set<String> visited = new HashSet<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        visited.add(sr + ":" + sc);
        floodFillHelper(image, sr + 1, sc, oldColor, newColor, visited);
        floodFillHelper(image, sr - 1, sc, oldColor, newColor, visited);
        floodFillHelper(image, sr, sc + 1, oldColor, newColor, visited);
        floodFillHelper(image, sr, sc - 1, oldColor, newColor, visited);
        return image;
    }

    public static void floodFillHelper(int[][] image, int sr, int sc, int oldColor, int newColor, Set<String> visited) {
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        visited.add(sr + ":" + sc);
        if(!visited.contains(sr+1 + ":" + sc))
            floodFillHelper(image, sr + 1, sc, oldColor, newColor, visited);
        if(!visited.contains(sr-1 + ":" + sc))
            floodFillHelper(image, sr - 1, sc, oldColor, newColor, visited);
        if(!visited.contains(sr + ":" + (sc+1)))
            floodFillHelper(image, sr, sc + 1, oldColor, newColor, visited);
        if(!visited.contains(sr + ":" + (sc-1)))
            floodFillHelper(image, sr, sc - 1, oldColor, newColor, visited);
    }

    /** Approach - 2 :: Same Approach without using visited data.
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 40.4 MB, less than 89.47% of Java online submissions.
     * */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor) {
            floodFillHelper2(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    public void floodFillHelper2(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if(image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            if(sr + 1 < image.length)
                floodFillHelper2(image, sr + 1, sc, oldColor, newColor);
            if(sr >= 1)
                floodFillHelper2(image, sr - 1, sc, oldColor, newColor);
            if(sc + 1 < image[0].length)
                floodFillHelper2(image, sr, sc + 1, oldColor, newColor);
            if(sc >= 1)
                floodFillHelper2(image, sr, sc - 1, oldColor, newColor);
        }
    }

    /** Helper method to print the Image matrix*/
    private static void print(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}