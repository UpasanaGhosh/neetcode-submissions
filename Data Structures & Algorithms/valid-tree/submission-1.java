class Solution {
    public boolean validTree(int n, int[][] edges) {
        // tree with n nodes can have only n-1 edges
        if(edges.length > n - 1) return false; 

        List<Integer>[] adjList = new List[n];
        Set<Integer> vis = new HashSet<>();

        for(int i=0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] e: edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{0, -1}); // [node, parent]
        vis.add(0);

        while(!bfsQ.isEmpty()){
            int len = bfsQ.size();
            
            for(int i=0; i < len; i++){
                int[] elem = bfsQ.poll();
                int curr = elem[0];
                int parent = elem[1];

                for(int neigh: adjList[curr]){
                    // Detect false cycles
                    if(neigh == parent) continue;
                    // Detect cycles
                    if(vis.contains(neigh)) return false;

                    bfsQ.offer(new int[]{neigh, curr});
                    vis.add(neigh);
                }
            }
        }
        // Tree only if the graph is fully connected
        return vis.size() == n;
    }
}