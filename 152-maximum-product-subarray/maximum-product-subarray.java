class Solution {
    public int maxProduct(int[] nums) {
        int maxsofar=nums[0];
        int minsofar=nums[0];
        int result=nums[0];

        for(int i=1;i<nums.length;i++){
            int current =nums[i];

            int tempmax=Math.max(current,Math.max(maxsofar*current, minsofar*current));
            minsofar=Math.min(current, Math.min(maxsofar*current, minsofar* current));
            maxsofar=tempmax;
            result=Math.max(result, maxsofar);

        }
        return result;
    }

public static void main(String [] args){
    Solution sol=new Solution();
    int[] nums1={2,3,-2,4};
    System.out.println("Output 1:" +sol.maxProduct(nums1));

    int[] nums2={-2,0,-1};
    System.out.println("Output 2:" +sol.maxProduct(nums2));

    int[] nums3={-2,3,-4};
    System.out.println("Output 3:" +sol.maxProduct(nums3));

}

}