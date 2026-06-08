class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;

                }else{
                    left=mid+1;
                }
            }
            else{
                if(target>nums[mid] && target <=nums[right]){
                    left=mid+1;

                }else{
                    right=mid-1;
                }
             
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution sol=new Solution();
        int num1[]={4,5,6,7,0,1,2};
        System.out.println("Output: "+sol.search(num1,0));
        int num2[]={4,5,6,7,0,1,2};
        System.out.println("Output 2: "+sol.search(num2,3));
        int  num3[]={1};
        System.out.println("Output 3:"  +sol.search(num3,0));
    }
}