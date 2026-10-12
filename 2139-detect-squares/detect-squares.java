class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> pointCount;
    private List<int[]> points;

    public DetectSquares() {
        pointCount = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        pointCount.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = pointCount.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int totalSquares = 0;

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                continue;
            }

            if (pointCount.containsKey(px) && pointCount.get(px).containsKey(y) &&
                pointCount.containsKey(x) && pointCount.get(x).containsKey(py)) {
                
                int count1 = pointCount.get(px).get(y);
                int count2 = pointCount.get(x).get(py);
                totalSquares += count1 * count2;
            }
        }

        return totalSquares;
    }
}