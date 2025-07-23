public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int left = 0, right = 0;
        int[] count = new int[26];
        int windowSize = 0;

        while (right < s.length()) {
            int index = s.charAt(right) - 'a';

            if (count[index] < 2) {
                count[index]++;
                windowSize = Math.max(windowSize, right - left + 1);
                right++;
            } else {
                int leftIndex = s.charAt(left) - 'a';
                count[leftIndex]--;
                left++;
            }
        }

        return windowSize;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring solver = new MaximumLengthSubstring();

        String s1 = "bcbbbcba";
        String s2 = "aaaa";
        String s3 = "abcabcabc";

        System.out.println("Input: " + s1 + " → Output: " + solver.maximumLengthSubstring(s1)); // Expected: 4
        System.out.println("Input: " + s2 + " → Output: " + solver.maximumLengthSubstring(s2)); // Expected: 2
        System.out.println("Input: " + s3 + " → Output: " + solver.maximumLengthSubstring(s3)); // Expected: 6
    }
}
