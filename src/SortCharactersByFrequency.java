import java.util.*;

/** https://leetcode.com/problems/sort-characters-by-frequency/ */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }

    static class Element {
        int count;
        char character;

        public Element(int count, char character) {
            this.count = count;
            this.character = character;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "count=" + count +
                    ", character=" + character +
                    '}';
        }
    }

    public static class ElementComparator implements Comparator<Element> {
        @Override
        public int compare(Element obj1, Element obj2) {
            return obj2.count - obj1.count;
        }
    }

    /**
     * LeetCode stats:
     * Runtime: 27 ms, faster than 22.75% of Java online submissions.
     * Memory Usage: 43 MB, less than 7.41% of Java online submissions
     * */
    public static String frequencySort(String s) {
        Map<Character, Element> lookup = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(lookup.containsKey(c)) {
                Element element = lookup.get(c);
                element.count += 1;
                lookup.put(c, element);
            } else {
                lookup.put(c, new Element(1, c));
            }
        }
        List<Element> data = new ArrayList<>();
        data.addAll(lookup.values());
        Collections.sort(data, new ElementComparator());

        StringBuffer result = new StringBuffer();
        for(Element element: data) {
            for(int i = 0; i < element.count; i++) {
                result.append(element.character);
            }
        }
        return result.toString();
    }
}
