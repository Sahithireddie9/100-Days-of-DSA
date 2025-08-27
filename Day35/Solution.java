package Day35;
import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') st.offerLast(')');
            else if (c == '{') st.offerLast('}');
            else if (c == '[') st.offerLast(']');
            else if (st.isEmpty() || st.removeLast() != c) return false;
        }
        return st.isEmpty();
    }
}
