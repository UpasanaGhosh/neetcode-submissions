class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 0) return n;

        Set<Integer> vis = new HashSet<>();
        List<Integer>[] adjList = new List[n];
        int connectedComps = 0;

        for(int i=0; i < n; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        for(int[] e: edges){
           adjList[e[0]].add(e[1]); 
           adjList[e[1]].add(e[0]); 
        }

        for(int i=0; i < n; i++){
            if(!vis.contains(i)){
                connectedComps++;
                dfs(i, adjList, vis);
            }
        }

        return connectedComps;
    }

    public void dfs(int curr, List<Integer>[] adjList, Set<Integer> vis){
        vis.add(curr);

        for(int neigh: adjList[curr]){
            if(!vis.contains(neigh)){
                dfs(neigh, adjList, vis);
            }
        }
    }
}
