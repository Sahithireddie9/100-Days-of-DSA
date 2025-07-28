package Day07;

public class MinWindowBruteForce {
    public static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (containsAllChars(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

    private static boolean containsAllChars(String window, String t) {
        int[] windowCount = new int[128];
        int[] tCount = new int[128];

        for (char c : window.toCharArray()) {
            windowCount[c]++;
        }

        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        for (int i = 0; i < 128; i++) {
            if (tCount[i] > windowCount[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window: " + minWindow(s, t)); // Output: BANC
    }
}

