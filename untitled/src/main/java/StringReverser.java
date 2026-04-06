import java.util.Stack;

public class StringReverser {
    public String reverse(String value){
        Stack<Character> stack = new Stack<>();
        for(char ch : value.toCharArray()){
            stack.push(ch);
        }
        StringBuffer rev = new StringBuffer();

        while (!stack.isEmpty()){
//            rev += stack.pop();

            rev.append(stack.pop());
        }

        return rev.toString();
    }
}
