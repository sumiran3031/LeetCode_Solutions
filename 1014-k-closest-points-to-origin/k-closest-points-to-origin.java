import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap stores pairs based on squared distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );
        
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        
        return maxHeap.toArray(new int[0][0]);
    }
}
