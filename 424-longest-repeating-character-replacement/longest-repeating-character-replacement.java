class Solution {
    public int characterReplacement(String s, int k) {
       int[] count=new int[26];
       int left=0;
       int maxfreq=0;
       int maxlen=0;
       for(int right=0;right<s.length();right++){
        char c=s.charAt(right);
        count[c-'A']++;
        maxfreq=Math.max(maxfreq,count[c-'A']);
        int windowsize=right-left+1;
        if(windowsize-maxfreq>k){
            count[s.charAt(left)-'A']--;
            left++;
        }
        maxlen=Math.max(maxlen,right-left+1);
       }
       return maxlen;
    }
    public static void main(String[] args){
        Solution sol=new Solution();
        System.out.println(sol. characterReplacement("ABAB",2));
        System.out.println(sol. characterReplacement("AABABBA",1));
        
    }
}