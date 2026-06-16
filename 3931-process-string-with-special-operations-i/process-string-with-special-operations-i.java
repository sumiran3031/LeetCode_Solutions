public class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.processStr("a*")); 
        System.out.println(sol.processStr("ab#")); 
        System.out.println(sol.processStr("abc%"));
        System.out.println(sol.processStr("ab*c#")); 
    }
}