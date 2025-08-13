package Day23;

public class Upperbound{
    
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
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 7};
        
        int target1 = 3;
        int target2 = 6;
        
        System.out.println("Upper Bound of " + target1 + ": " + upperBound(arr, target1)); // Output: 3
        System.out.println("Upper Bound of " + target2 + ": " + upperBound(arr, target2)); // Output: 4
    }
}
