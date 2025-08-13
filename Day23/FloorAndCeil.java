package Day23;

public class FloorAndCeil {

    // Lower Bound: first index where arr[i] >= target
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Upper Bound: first index where arr[i] > target
    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static Integer findCeil(int[] arr, int target) {
        int lb = lowerBound(arr, target);
        if (lb == arr.length) return null; // No Ceil exists
        return arr[lb];
    }

    public static Integer findFloor(int[] arr, int target) {
        int ub = upperBound(arr, target);
        int floorIndex = ub - 1;
        if (floorIndex < 0) return null; // No Floor exists
        return arr[floorIndex];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        
        int target = 6;
        Integer ceil = findCeil(arr, target);
        Integer floor = findFloor(arr, target);

        System.out.println("Array: [1, 3, 5, 7, 9]");
        System.out.println("Target: " + target);
        System.out.println("Ceil: " + (ceil != null ? ceil : "No Ceil"));
        System.out.println("Floor: " + (floor != null ? floor : "No Floor"));
    }
}
