class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0, right = 0;
        long sum = 0;
        long score = 0;
        long count = 0;
        while(right < nums.length){
            sum += nums[right];
            score = sum * (right - left + 1);
            while( score >= k){
                sum -= nums[left];
                left++;
                score = sum * (right - left + 1);
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna