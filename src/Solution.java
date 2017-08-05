import java.util.*;

public class Solution {
// Write your code here.

    LinkedList queue;
    Stack<Character> stack;

    // making a queue instance
    public Solution(){
        queue = new LinkedList();
        stack = new Stack<>();
    }

    // method that pushes a character onto a stack.
    private void enqueueCharacter(char c) {
        queue.addLast(c);
    }

    // method that enqueues a character in the queue instance
    private void pushCharacter(char c) {
        stack.push(c);
    }

    // method that pops and returns the character at the top of
    // the stack instance variable.
    private char popCharacter() {
        return stack.pop();
    }

    // method that dequeues and returns the first character in
    // the queue instance variable.
    private char dequeueCharacter() {
        return (char) queue.remove(0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}