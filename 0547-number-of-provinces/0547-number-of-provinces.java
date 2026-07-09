class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        //making provinces(groups) using dsu
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i,j);
                }
            }
        }
        //every union decreases no. of provinces as initally they are n
        return dsu.provinces;
    }

    class DSU{
        int[] parent;
        int[] size;
        int provinces;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            provinces = n;

            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] == x) return x;

            parent[x] = find(parent[x]);

            return parent[x];
        }

        void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);

            if(parentA == parentB) return ;

            if(size[parentA] < size[parentB]){
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
            }

            else{
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
            }
            provinces--;
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna