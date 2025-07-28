package Day07;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128]; // ASCII

        // Fill target frequencies
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int required = t.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (freq[rChar] > 0) required--;
            freq[rChar]--;
            right++;

            // Shrink the window
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                freq[lChar]++;
                if (freq[lChar] > 0) required++; // character is needed again
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
