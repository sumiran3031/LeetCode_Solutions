import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] words = curr.toCharArray();
                for (int j = 0; j < words.length; j++) {
                    char originalChar = words[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (words[j] == c) {
                            continue;
                        }
                        words[j] = c;
                        String nextWord = String.valueOf(words);
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(nextWord)) {
                            queue.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    words[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
