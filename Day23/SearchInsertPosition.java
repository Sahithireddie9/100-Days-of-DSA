package Day23;
public class SearchInsertPosition {
    
    public static int searchInsert(int[] arr, int target) {
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
        int[] arr = {1, 3, 5, 6};
        
        System.out.println(searchInsert(arr, 5)); // Output: 2 (target found at index 2)
        System.out.println(searchInsert(arr, 2)); // Output: 1 (should be inserted before index 1)
        System.out.println(searchInsert(arr, 7)); // Output: 4 (insert at end)
        System.out.println(searchInsert(arr, 0)); // Output: 0 (insert at start)
    }
}
