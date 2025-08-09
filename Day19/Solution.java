package Day19;

import java.util.*;

public class Solution {
    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // end asc
            return Integer.compare(a[0], b[0]);                    // start asc (tie)
        });

        int count = 0;
        int lastEnd = -1; // or Integer.MIN_VALUE
        for (int[] m : meetings) {
            if (m[0] > lastEnd) {   // strictly greater
                count++;
                lastEnd = m[1];
            }
        }
        return count;
    }

    // quick test
    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1,3,0,5,8,5}, new int[]{2,4,6,7,9,9})); // 4
        System.out.println(maxMeetings(new int[]{10,12,20}, new int[]{20,25,30}));       // 1
        System.out.println(maxMeetings(new int[]{1,2}, new int[]{100,99}));              // 1
    }
}
