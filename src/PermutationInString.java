/** https://leetcode.com/problems/permutation-in-string/ */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    /** Approach :
     * Generate possible substrings of s1 length and check if they are anagrams.
     *
     * LeetCode stats:
     * Runtime: 289 ms, faster than 12.89% of Java online submissions.
     * Memory Usage: 39.5 MB, less than 7.69% of Java online submissions.
     * */
    public static boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i <= s2.length() - s1.length(); i++) {
            String sub = s2.substring(i, i + s1.length());
            if(areAnagrams(s1, sub)) {
                return true;
            }
        }
        return false;
    }

    public static boolean areAnagrams(String s1, String s2) {
        int[] lookup = new int[26];
        for(char c: s1.toCharArray()) {
            lookup[c-'a']++;
        }
        for(char c: s2.toCharArray()) {
            lookup[c-'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(lookup[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
