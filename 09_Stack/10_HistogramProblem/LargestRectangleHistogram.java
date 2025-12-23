import java.util.Stack;

public class LargestRectangleHistogram {

    // Function to calculate the largest rectangle area in the histogram
    public static int largestRectangleArea(int[] heights) {
        // Stack to store the indices of the bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Traverse each bar in the histogram
        for (int i = 0; i <= n; i++) {
            // We push a height of 0 at the end to handle remaining bars in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the stack is not empty and current height is less than height at top of stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int poppedIndex = stack.pop(); // index of the shorter bar
                int height = heights[poppedIndex]; // height of the popped bar

                // If stack is empty, width = i (entire width till current)
                // Else, width = distance between current index and the index at the new top of the stack - 1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Calculate area and update maxArea
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            // Push the current index to the stack
            stack.push(i);
        }

        return maxArea;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Example histogram: Each index represents a bar, each value is its height
        int[] heights = {2, 1, 5, 6, 2, 3};

        /*
         * Explanation:
         * In this histogram, the largest rectangle has area = 10,
         * which comes from heights 5 and 6 with width = 2.
         */
        
        int result = largestRectangleArea(heights);
        System.out.println("Largest rectangle area in histogram: " + result);
    }
}
