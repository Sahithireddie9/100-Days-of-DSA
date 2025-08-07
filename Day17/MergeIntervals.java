package Day17;
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a list to hold merged intervals
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged is empty OR no overlap, just add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // If overlapping, merge with the last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        // Convert list to 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }

    
}
