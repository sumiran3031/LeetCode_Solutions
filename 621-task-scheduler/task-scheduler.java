class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }

        int intervals = (maxFreq - 1) * (n + 1) + maxFreqCount;
        
        return Math.max(tasks.length, intervals);
    }
}
