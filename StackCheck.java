import java.util.Stack;

public class StackCheck {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>(); 
        
        for(char ch : expression.toCharArray()) {
            // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check closing brackets
            else if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String[] expressions = {
            "{[(]]}",
            "{[(])}",
            "(((]]}",
            "({[}])",
            "({()})"
        };
        
        for(String expr : expressions) {
            System.out.println(expr + " is balanced? " + isBalanced(expr));
        }
    }
}
