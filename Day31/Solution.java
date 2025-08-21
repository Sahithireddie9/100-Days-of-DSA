package Day31;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Find the maximum pile (upper bound of k)
        for (int p : piles) {
            high = Math.max(high, p);
        }
        
        // Binary search on eating speed k
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                high = mid;   // mid works, try smaller k
            } else {
                low = mid + 1; // mid too slow, try bigger k
            }
        }
        
        return low;
    }
    
    // Helper to check if Koko can finish at speed k
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;  // use long to avoid overflow
        for (int p : piles) {
            hours += (p + k - 1) / k;  // ceil division
            if (hours > h) return false; // early exit
        }
        return hours <= h;
    }
}
