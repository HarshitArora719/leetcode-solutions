class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count1 = subarrayWithAtMostK(nums,k);
        int count2 = subarrayWithAtMostK(nums,k-1);
        return count1 - count2;
    }
    public int subarrayWithAtMostK(int[] nums, int k){
        int left = 0;
        int right = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            while(map.size() > k){
                int freq = map.get(nums[left]);
                map.put(nums[left],freq - 1);
                if(freq == 1) map.remove(nums[left]);
                left++;
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