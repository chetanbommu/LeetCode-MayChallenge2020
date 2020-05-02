import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/jewels-and-stones/ */
public class JewelsAndStones {

    /** Main Method to Test the code*/
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones_UsingArray(J, S));
    }

    /** Approach :: Storing Jewels in Either a Set or Map.
     * Now traverse the stones and see if each stone is a Jewel.
     *
     * LeetCode stats:
     * Runtime: 1 ms, faster than 69.83% of Java online submissions.
     * Memory Usage: 38 MB, less than 5.05% of Java online submissions.
     * */
    public static int numJewelsInStones(String J, String S) {
        int countOfJewels = 0;
        Set<Character> jewels = new HashSet<>();
        for(char jewel : J.toCharArray()) {
            jewels.add(jewel);
        }

        for(char stone : S.toCharArray()) {
            if(jewels.contains(stone)) {
                countOfJewels++;
            }
        }

        return countOfJewels;
    }


    /** Approach :: Storing Jewels in Array for access in O(1).
     * Now traverse the stones and see if each stone is a Jewel.
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37.8 MB, less than 5.05% of Java online submissions
     * */
    public static int numJewelsInStones_UsingArray(String J, String S) {
        int countOfJewels = 0;

        /** Memory to store A-Z & a-z.
         * ASCII of A: 65, z:122 => Difference is 58.
         * */
        int[] lookup = new int[58];
        for(int index = 0; index < J.length(); index++) {
            lookup[J.charAt(index) - 'A']++;
        }

        for(int index = 0; index < S.length(); index++) {
            countOfJewels += lookup[S.charAt(index)-'A'];
        }
        return countOfJewels;
    }
}