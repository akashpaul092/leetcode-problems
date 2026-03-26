class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i< n; i++) list.add(new ArrayList<>());
        for(int i=0; i< edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < n; i++){
            indegree[i] = list.get(i).size();
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }
        int rem = n;
        while(rem > 2){
            int size = queue.size();
            rem -= size;

            for(int i=0; i<size; i++){
                int ele = queue.poll();
                for(int j=0; j< list.get(ele).size(); j++){
                    indegree[list.get(ele).get(j)]--;
                    if(indegree[list.get(ele).get(j)] == 1){
                        queue.offer(list.get(ele).get(j));
                    }
                }
            }
        }

        return new ArrayList<>(queue);

    }
}