
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                ans = mid;        
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long totalHours = 0; 
        
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
            if (totalHours > h) {
                return false;
            }
        }
        return totalHours <= h;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Minimum eating speed: " + solver.minEatingSpeed(piles, h)); 
        
    }
}
