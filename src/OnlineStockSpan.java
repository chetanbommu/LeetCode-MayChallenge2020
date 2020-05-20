import java.util.Stack;

/** https://leetcode.com/problems/online-stock-span/ */
public class OnlineStockSpan {

    class Stock {
        int price;
        int dayIndex;

        public Stock(int price, int dayIndex) {
            this.price = price;
            this.dayIndex = dayIndex;
        }
    }

    Stack<Stock> stack;
    int dayIndex;

    public static void main(String[] args) {
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] prices2 = new int[] {31, 41, 48, 59, 79};
        OnlineStockSpan app = new OnlineStockSpan();
        for(int price: prices2) {
            System.out.println(app.next(price));
        }
    }

    public OnlineStockSpan() {
        stack = new Stack<>();
        dayIndex = 1;
    }

    /**
     * LeetCode stats:
     * Runtime: 36 ms, faster than 16.12% of Java online submissions.
     * Memory Usage: 48.1 MB, less than 100.00% of Java online submissions.
     * */
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().price < price) {
            stack.pop();
        }
        int span = stack.isEmpty() ? dayIndex : dayIndex - stack.peek().dayIndex;
        Stock stock = new Stock(price, dayIndex);
        dayIndex++;
        stack.push(stock);
        return span;
    }
}
