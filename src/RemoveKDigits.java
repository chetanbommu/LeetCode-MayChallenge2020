import java.util.Stack;

/** https://leetcode.com/problems/remove-k-digits/ */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    /** Approach :
     * Insert the elements into the stack using the following rules.
     * i) If top of the stack is greater than current element, pop that element. Because it makes the number larger.
     * ii) If stack is empty (or) current element is greater than stack top, push the element.
     * iii) After finishing pushing all the elements, If k is still greater than zero, pop k elements.
     * iv) When k becomes 0, pop elements and append them into string which will give us the required number.
     *
     * LeetCode stats:
     * Runtime: 20 ms, faster than 23.21% of Java online submissions.
     * Memory Usage: 39.6 MB, less than 9.09% of Java online submissions.
     * */
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < num.length(); i++) {
            int currentDigit = num.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek() > currentDigit && k > 0) {
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || currentDigit != 0) {
                stack.push(currentDigit);
            }
        }

        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result.isEmpty() ? "0" : result;
    }
}
