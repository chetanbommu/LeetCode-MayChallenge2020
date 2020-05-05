import java.util.HashMap;

/** https://leetcode.com/problems/first-unique-character-in-a-string/ */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }

    /** Approach - 1 :: Generate a lookup with character and its occurrences.
     * Iterate over the string, for each character check if it has occured only once.
     * If so, return that character index. Else return -1
     *
     * LeetCode stats:
     * Runtime: 23 ms, faster than 44.05% of Java online submissions.
     * Memory Usage: 39.9 MB, less than 7.86% of Java online submissions.
     * */
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> lookup = new HashMap<>();
        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            lookup.put(ch, lookup.getOrDefault(ch, 0) + 1);
        }

        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            int value = lookup.get(ch);
            if(value == 1) {
                return index;
            }
        }
        return -1;
    }

    /** Approach - 2 :: Initialize an array of size 26 i.e., No of alphabets.
     * For each character in String, increment its index in array by 1.
     * Iterate over the string, check if it's value is 1 i.e., Occurred only once.
     * If so, return that character index. Else return -1
     *
     * LeetCode stats:
     * Runtime: 8 ms, faster than 75.59% of Java online submissions.
     * Memory Usage: 39.6 MB, less than 22.86% of Java online submissions.
     * */
    public int firstUniqChar_UsingArray(String s) {
        int[] charArray = new int[26];
        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            charArray[ch-'a']++;
        }

        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if(charArray[ch-'a'] == 1) {
                return index;
            }
        }
        return -1;
    }
}
