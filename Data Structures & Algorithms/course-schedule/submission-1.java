class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] indeg = new int[numCourses];
        int courseTaken = 0;

        for(int i=0; i < numCourses; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        // 1. Build the adj list and indegrees
        for(int[] pre: prerequisites){
            adjList[pre[1]].add(pre[0]);
            indeg[pre[0]]++;
        }

        // 2. Run BFS 
        Queue<Integer> bfsQ = new ArrayDeque<>();
        for(int i=0; i < numCourses; i++){
            if(indeg[i] == 0) bfsQ.offer(i);
        }

        while(!bfsQ.isEmpty()){
            int len = bfsQ.size();

            for(int i=0; i < len; i++){
                int curr = bfsQ.poll();
                for(int next: adjList[curr]){
                   indeg[next]--;
                   if(indeg[next] == 0) bfsQ.offer(next); 
                }
                courseTaken++;
            }
        }

        // 3. Check if courseTaken == numCourses to finish all courses
        return courseTaken == numCourses;
    }
}
