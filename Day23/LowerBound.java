package Day23;
public class LowerBound {

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
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 7};
        
        int target1 = 3;
        int target2 = 4;
        
        System.out.println("Lower Bound of " + target1 + ": " + lowerBound(arr, target1)); // Output: 1
        System.out.println("Lower Bound of " + target2 + ": " + lowerBound(arr, target2)); // Output: 3
    }
}

