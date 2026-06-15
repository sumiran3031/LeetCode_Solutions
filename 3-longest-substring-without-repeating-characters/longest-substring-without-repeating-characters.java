class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int maxlength=0;
        int left=0;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);

            if(map.containsKey(c) && map.get(c)>=left){
                left=map.get(c)+1;
            }
            map.put(c,right);
            maxlength=Math.max(maxlength, right-left+1);
       
    }
    return maxlength;
}
public static void main(String args[]){
    Solution sol=new Solution();
    System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
    System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
}
}