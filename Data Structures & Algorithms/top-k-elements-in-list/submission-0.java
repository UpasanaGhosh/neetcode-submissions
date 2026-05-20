class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int n: nums){
           freqMap.put(n, freqMap.getOrDefault(n, 0) + 1); 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        for(int n: freqMap.keySet()){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }

        return res;
    }
}
