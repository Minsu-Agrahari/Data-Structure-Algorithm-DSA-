/*
    * Next Greater Element
 * Stack Usage: A stack is used to keep track of elements that we have encountered but 
 * have not yet found their next greater element.
 *
 * Iterating from Right to Left: We traverse the array from right to left. 
 * This helps us keep track of the next greater elements for each element in a 
 * manner where the stack always contains the elements that could potentially 
 * be the next greater elements for elements we are currently checking.
 * 
 * Stack Operations:
 * 
 * Pop Operation: While the top of the stack has an element smaller than or equal
 * to the current element, we pop it off. These elements cannot be the 
 * "next greater element" for the current element or any future elements, so we 
 * remove them.
 * 
 * Push Operation: After we have determined the next greater element (or not), 
 * we push the current element onto the stack, so it can be used for subsequent 
 * comparisons.
 * 
 * Output: For each element, if the stack is not empty, the top of the stack 
 * is the next greater element. If the stack is empty, it means there is no greater 
 * element, so we print -1 for that element.
 * 
 * Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
 * Space Complexity: O(n) - In the worst case, all elements are stored in the stack.
 * 
*/
import java.util.Stack;

public class NextGreaterElement {

    // Function to find the next greater element for each element in the array
    public static void nextGreater(int[] nums) {
        // Create a stack to store elements for which we have not found the next greater element yet
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from the stack that are less than or equal to the current element
            // Because we need the next greater element and these elements can't be the next greater
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            
            // If the stack is not empty, the element on the top is the next greater element for nums[i]
            if (!stack.isEmpty()) {
                System.out.println("Next Greater Element for " + nums[i] + " is " + stack.peek());
            } else {
                // If the stack is empty, there is no greater element, so print -1
                System.out.println("Next Greater Element for " + nums[i] + " is -1");
            }
            
            // Push the current element onto the stack for future comparisons
            stack.push(nums[i]);
        }
    }

    // Main method to test the nextGreater function
    public static void main(String[] args) {
        // Example array
        int[] nums = {4, 5, 2, 10, 8};
        
        // Call the nextGreater function to find the next greater element for each element
        nextGreater(nums);
    }
}
