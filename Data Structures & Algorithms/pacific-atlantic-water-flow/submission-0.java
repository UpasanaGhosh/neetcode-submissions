class Solution {
    int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, cols - 1, atlantic, heights[i][cols - 1]);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, rows - 1, j, atlantic, heights[rows - 1][j]);
        }

        List<List<Integer>> elements = new ArrayList<>();
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> idx = new ArrayList<>();
                    idx.add(i);
                    idx.add(j);
                    elements.add(idx);
                }
            }
        }
        return elements;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length 
           || ocean[r][c] || heights[r][c] < prevHeight) return;

        ocean[r][c] = true;
        for(int[] dir : dirs){
            dfs(heights, r + dir[0], c + dir[1], ocean, heights[r][c]);
        }
    }
}