class Solution {
    public String removeKdigits(String num, int k) {
        // If we remove all digits, return "0"
        if (k >= num.length()) return "0";

        StringBuilder stack = new StringBuilder(); // acts like a stack

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            // Remove larger digits on the left if current digit is smaller
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // If still have removals left, remove from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        // Build the result
        String res = (idx == stack.length()) ? "" : stack.substring(idx);

        return res.isEmpty() ? "0" : res;
    }
}
