package Day16;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move to next character in s
            }
            j++; // Always move in t
        }

        return i == s.length(); // True if we matched entire s
    }

    // Optional main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(sol.isSubsequence("", "ahbgdc"));    // true
        System.out.println(sol.isSubsequence("abc", ""));       // false
    }
}

