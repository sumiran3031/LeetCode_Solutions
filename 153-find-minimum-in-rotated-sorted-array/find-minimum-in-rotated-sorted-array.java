class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left +(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
                }
                else{
                    right=mid;

                }
        }
        return nums[left];

    }
    public static void main(String[] args){
        Solution sol=new Solution();
        int[] num1={3,4,5,1,2};
        System.out.println("Output 1:" +sol.findMin(num1));

        int[] num2={4,5,6,7,0,1,2};
        System.out.println("Output 2:" +sol.findMin(num2));
        int[] num3={11,13,15,17};
        System.out.println("Output 3;" +sol.findMin(num3));
    }
}