class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans,new ArrayList<>() ,0,candidates,target);
        return ans;
    }
    private void solve( List<List<Integer>> ans, List<Integer> subset,int i, int[] arr, int target){
        if(i==arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(subset));
            }
            return;
        }
        if(arr[i] <= target){
            subset.add(arr[i]);
            solve(ans,subset,i,arr,target-arr[i]);
            subset.remove(subset.size()-1);
        } 
        solve(ans,subset,i+1,arr,target);
    }
}