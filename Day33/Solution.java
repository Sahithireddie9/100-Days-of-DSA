package Day33;
class RowWithMaxOnes {
    public static int rowWithMaxOnes(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) return -1;
        int n = arr.length, m = arr[0].length;

        int r = 0, c = m - 1;
        int bestRow = -1;
        int leftmost = m; // smallest column index of a '1' found so far

        while (r < n && c >= 0) {
            if (arr[r][c] == 1) {
                // Only update if we strictly improve (earlier '1' column),
                // which preserves the smallest row index on ties.
                if (c < leftmost) {
                    leftmost = c;
                    bestRow = r;
                }
                c--; // move left
            } else {
                r++; // move down
            }
        }
        return bestRow;
    }

   
}
