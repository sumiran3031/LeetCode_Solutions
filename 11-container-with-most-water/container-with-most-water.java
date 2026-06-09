class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxWater=0;
        while(left<right){
            int water=Math.min(height[left],height[right])*(right-left);
            maxWater=Math.max(maxWater,water);
            if(height[left]<height[right]){
                left++;

            }else{
                right--;
            }
        }
        return maxWater;

    }
    public static void main(String[] args){
        Solution sol=new Solution();
        int [] height1={1,8,6,2,5,4,8,3,7};
        System.out.println("Output1:" +sol.maxArea(height1));
        int[] height2={1,1};
        System.out.println("Output 2:" +sol.maxArea(height2));
    }
}