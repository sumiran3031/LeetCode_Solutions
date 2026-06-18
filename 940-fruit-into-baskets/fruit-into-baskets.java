import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCounts = new HashMap<>();
        int maxFruits = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            fruitCounts.put(currentFruit, fruitCounts.getOrDefault(currentFruit, 0) + 1);
            while (fruitCounts.size() > 2) {
                int leftFruit = fruits[left];
                fruitCounts.put(leftFruit, fruitCounts.get(leftFruit) - 1);
                if (fruitCounts.get(leftFruit) == 0) {
                    fruitCounts.remove(leftFruit);
                }
                left++; 
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
