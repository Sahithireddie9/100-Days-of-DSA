package Day18;
import java.util.*;
class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];
        List<int[]> out = new ArrayList<>();

        // left non-overlapping
        while (i < n && intervals[i][1] < start) out.add(intervals[i++]);

        // merge overlapping
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end   = Math.max(end, intervals[i][1]);
            i++;
        }
        out.add(new int[]{start, end});

        // right non-overlapping
        while (i < n) out.add(intervals[i++]);

        return out.toArray(new int[out.size()][2]);
    }
}
