package Day32;
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);   // at least the heaviest package
            hi += w;                // at most sum of all packages
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;   // trial capacity
            if (canShip(weights, days, mid)) {
                hi = mid;                   // mid works; try smaller
            } else {
                lo = mid + 1;               // mid too small; go bigger
            }
        }
        return lo; // minimal feasible capacity
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int usedDays = 1, load = 0;
        for (int w : weights) {
            if (load + w <= cap) {
                load += w;
            } else {
                usedDays++;
                if (usedDays > days) return false; // early stop
                load = w; // start new day with current package
            }
        }
        return true;
    }
}
