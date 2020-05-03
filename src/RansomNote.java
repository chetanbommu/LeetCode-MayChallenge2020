package strings;

/** https://leetcode.com/problems/ransom-note/ */
public class RansomNote {

    /** Main Method to Test the code*/
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    /** Approach ::
     * Though it is not given in the description, From the examples it seemed that we are only dealing small case alphabets.
     * We can count the occurrence of each character from the magazine and store in an array of size: 26 i.e., Which is enough to store 26 alphabets.
     * Iterate over the magazine and store count of each character.
     * Now, Iterate over ransom note and decrement count for each character.
     * If we see any values less than 0, than It is not possible to from ransom note from Magazine, Because we saw a character occur more in ransom note than it appeared in magazine.
     *
     * LeetCode stats:
     * Runtime: 2 ms, faster than 98.69% of Java online submissions.
     * Memory Usage: 39.6 MB, less than 11.54% of Java online submissions.
     * */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] lookup = new int[26];
        for(char c: magazine.toCharArray()) {
            lookup[c-'a']++;
        }
        for(char c: ransomNote.toCharArray()) {
            lookup[c-'a']--;
        }
        for(int i = 0; i< 26; i++) {
            if(lookup[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
