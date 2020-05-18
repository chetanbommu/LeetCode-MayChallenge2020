package strings;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/find-all-anagrams-in-a-string/ */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        System.out.println(s.length() - p.length());
        for(int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            System.out.println("Sub : " + sub);
            if(areAnagrams(sub, p)) {
                indices.add(i);
            }
        }
        return indices;
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
