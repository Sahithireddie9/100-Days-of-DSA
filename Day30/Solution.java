package Day30;

class FloorSquareRoot {
    public static int floorSqrt(int n) {
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == n) {
                return mid; // perfect square
            } else if (mid * mid < n) {
                ans = mid;  // candidate
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));  // 2
        System.out.println(floorSqrt(11)); // 3
        System.out.println(floorSqrt(1));  // 1
    }
}

