class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];
        len[0] = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = len[i] * 2;
            } else if (c == '%') {
                len[i + 1] = len[i];
            } else {
                len[i + 1] = len[i] + 1;
            }
        }

        if (k >= len[n]) return '.';

        boolean reversed = false;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                continue;
            } else if (c == '#') {
                long half = len[i];
                if (k >= half) {
                    k -= half;
                }
            } else if (c == '%') {
                long currentLen = len[i + 1];
                k = currentLen - 1 - k;
            } else {
                if (k == len[i + 1] - 1) {
                    return c;
                }
            }
        }

        return '.';
    }
}