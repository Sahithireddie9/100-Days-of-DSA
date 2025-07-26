public class LongestSubstringWithoutRepeatingCharacters {

    // Optimal Sliding Window Approach
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, windowSize = 0;
        int[] count = new int[256]; // For ASCII characters

        while (right < s.length()) {
            int index = s.charAt(right);

            // If character not yet in window
            if (count[index] == 0) {
                count[index]++;
                windowSize = Math.max(windowSize, right - left + 1);
                right++;
            } else {
                // Shrink window from left until duplicate removed
                int leftIndex = s.charAt(left);
                count[leftIndex]--;
                left++;
            }
        }

        return windowSize;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(lengthOfLongestSubstring("bbbb"));       // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));     // 3
        System.out.println(lengthOfLongestSubstring(""));           // 0
        System.out.println(lengthOfLongestSubstring("abcdef"));     // 6
        System.out.println(lengthOfLongestSubstring("abba"));       // 2
    }
}
