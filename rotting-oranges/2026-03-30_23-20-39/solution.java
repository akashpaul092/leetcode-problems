class RottenOrange{
    int row;
    int col;
    int count;
    RottenOrange(int row, int col, int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<RottenOrange> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int freshCount = 0;
        int rottenCount = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j< col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new RottenOrange(i, j, 0));
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;
        while(!queue.isEmpty()){
            RottenOrange element = queue.poll();
            count = Math.max(count, element.count);

            for(int[] direction: directions){
                int dr = element.row + direction[0];
                int dc = element.col + direction[1];

                if(dr >= 0 && dr < row && dc >=0 && dc < col && grid[dr][dc] == 1){
                    grid[dr][dc] = 2;
                    rottenCount++;
                    queue.offer(new RottenOrange(dr, dc, element.count + 1));
                }
            }
        }

        return freshCount == rottenCount ? count : -1;
    }
}