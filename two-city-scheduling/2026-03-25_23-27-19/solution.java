class Difference{
    int diff;
    int cityA;
    int cityB;
    Difference(int diff, int cityA, int cityB){
        this.diff = diff;
        this.cityA = cityA;
        this.cityB = cityB;
    }
}
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        PriorityQueue<Difference> pq = new PriorityQueue<>( (a,b) -> a.diff - b.diff);
        
        for(int[] cost: costs){
            pq.offer(new Difference(cost[1] - cost[0], cost[0], cost[1]));
        }
        int i=0;
        int ans = 0;
        while(!pq.isEmpty()){
            Difference val = pq.poll();
            if(i < n/2){
                ans += val.cityB;
            }
            else{
                ans += val.cityA;
            }
            i++;
        }
        return ans;
    }
}