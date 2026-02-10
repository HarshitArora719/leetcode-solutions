class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        solve(0,s,ans,new ArrayList<>());
        return ans;
    }
    private void solve(int i, String s, List<List<String>> ans,List<String> path){
        if(i == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(ispalindrome(s,i,j)){
                path.add(s.substring(i,j+1));
                solve(j+1,s,ans,path);
                path.remove(path.size()-1);                
            }
        }

    }
    private boolean ispalindrome(String s, int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}