class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            list.get(u).add(new int[]{v,t});
        }

        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            int currNode = ele[1];
            int currTime = ele[0];        

            // if(currTime > arr[currNode]) continue;

            for(int i=0; i< list.get(currNode).size(); i++){
                int[] adjEle = list.get(currNode).get(i);
                if(currTime + adjEle[1] < arr[adjEle[0]]){
                    arr[adjEle[0]] = currTime + adjEle[1];
                    pq.offer(new int[]{currTime + adjEle[1], adjEle[0]});
                }
            }
        }

        int minPath = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(arr));
        for(int i=1; i<=n; i++){
            if(arr[i] == Integer.MAX_VALUE) return -1;
            minPath = Math.max(minPath, arr[i]);
        }
        return minPath;
    }
}