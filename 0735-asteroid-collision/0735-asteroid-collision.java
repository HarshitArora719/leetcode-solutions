class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            boolean flag = true;
            while(asteroids[i] < 0 && !st.isEmpty() && st.peek() > 0){
                if(-asteroids[i] > st.peek()){
                    // Stack asteroid is smaller -> it explodes
                    st.pop();
                }
                else if(st.peek() > -asteroids[i]){
                    // Incoming asteroid is smaller -> it explodes
                    flag = false;
                    break;
                }
                else{
                    // Both are same size -> both explode
                    st.pop();
                    flag = false;
                    break;
                }
            }
            if(flag){
                st.push(asteroids[i]);
            }
        }
        int res[] = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna