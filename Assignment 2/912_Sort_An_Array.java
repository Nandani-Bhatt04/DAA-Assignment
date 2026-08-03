class Solution {

    private void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int left = low;        
        int right = mid + 1;   
        int idx = low;       

        
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

       
        while (right <= high) {
            temp[idx++] = nums[right++];
        }

       
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }

    
    private void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return; 
        }

        int mid = low + (high - low) / 2; 
        mergeSort(nums, low, mid, temp);       
        mergeSort(nums, mid + 1, high, temp);   
        merge(nums, low, mid, high, temp);      
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];     
        mergeSort(nums, 0, n - 1, temp);
        return nums;
    }
}
