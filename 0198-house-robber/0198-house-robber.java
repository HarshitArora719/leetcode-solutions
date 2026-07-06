class Solution {
    public int dp(int i, int[] nums, Map<Integer,Integer> cache){
        if(i == 0) return nums[i];

        if(i == 1) return Math.max(nums[0],nums[1]);

        if(cache.containsKey(i)) return cache.get(i);

        cache.put(i, Math.max(dp(i - 1, nums, cache),nums[i] + dp(i - 2, nums, cache)));
        
        return cache.get(i);
    }
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return dp(nums.length-1,nums,map);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna