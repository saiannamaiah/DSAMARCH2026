import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IsBalanced {
    List<Character> leftBrackets = Arrays.asList('(','{','[','<');
    List<Character> rightBrackets = Arrays.asList(']','}',']','>');
    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()){
            if(isLeftBracket(ch)){
                stack.push(ch);
            } else if(isRightBracket(ch)){
                if(stack.isEmpty()) return false;
                var top = stack.pop();
                if(bracketsMatch(top,ch)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) != leftBrackets.indexOf(right);
    }
}
