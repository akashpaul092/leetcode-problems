class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        int row = isConnected.length;
        int col = isConnected[0].length;
        for(int i=0; i< row; i++) list.add(new ArrayList<>());
        for(int i=0; i< row; i++){
            for(int j=0; j< row; j++){
                if (isConnected[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[row];
        int count = 0;
        for(int i=0; i< row; i++){
            if(!vis[i]){ 
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int ele = q.poll();
                    vis[ele] = true;
                    for(int it: list.get(ele)){
                        if(!vis[it]){
                            q.offer(it);
                        }
                    }
                }
            }
        }
        return count;
    }
}