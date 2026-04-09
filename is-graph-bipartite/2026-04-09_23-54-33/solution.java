class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        int row = graph.length;
        for(int i = 0; i< row; i++) list.add(new ArrayList<>());
        for(int i = 0; i< row; i++){
            for(int j=0; j<graph[i].length; j++){
                list.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[row];
        Arrays.fill(color, -1);
        for(int i = 0; i< row; i++){
            if(color[i] == -1){
                if(!dfs(list, color, 1, i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> list, int[] color, int isColor, int index){
        if(index == list.size()) return true;

        color[index] = isColor;
        for(int i=0; i<list.get(index).size(); i++){
            int ele = list.get(index).get(i);
            if(color[ele] == -1){
                if(!dfs(list, color, 1 - isColor, ele)) return false;
            }else if(color[ele] == isColor){
                return false;
            }
        }
        return true;
    }
}