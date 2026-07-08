class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] ans = new int[queries.length]; 
        //preprocess sum
        int[] prefixsum = new int[n + 1];

        prefixsum[0]=0;

        for(int i = 0; i < n; i++){
            prefixsum[i + 1] = prefixsum[i] + (s.charAt(i) - '0');
        }
        
        //preprocess number
        long[] prefValue = new long[n+1];
        int[] cnt = new int[n+1];
        int c =0;
        long cur = 0;
        for(int i = 0; i < n; i++){
            int digit = s.charAt(i) - '0';

            if(digit != 0){
                cur = (cur * 10 + digit) % MOD;
                c++;
            }
            cnt[i+1]=c;
            prefValue[i+1]= cur;
        }

        //pow 10
        int[] pow10 = new int[n+1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (int)((pow10[i - 1] * 10L) % MOD);
        }

        //calculate ans
        int sum = 0;
        long x = 0;
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0] , r = queries[i][1];
            sum = prefixsum[r+1] - prefixsum[l]; 
            int k = pow10[cnt[r + 1] - cnt[l]];
            x = (prefValue[r+1] - (prefValue[l] * k) % MOD + MOD) % MOD;
            ans[i] = (int)((sum * x) % MOD);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna