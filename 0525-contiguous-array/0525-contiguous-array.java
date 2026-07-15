class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += (nums[i] == 0) ? -1 : 1;
            map.putIfAbsent(prefixSum, i);
            ans = Math.max(ans, i - map.get(prefixSum));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna