/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.49%)
 * Total Accepted:    325.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * Frist Version: a dfs version
 * Second Version: dp version
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
      boolean[][] dp = new boolean[s.length()+1][p.length()+1];
      dp[s.length()][p.length()] = true;
      for (int i = s.length(); i >= 0; i--) {
        for (int j = p.length() - 1; j >= 0; j--) {
          boolean first_match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
          if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
          } else {
            dp[i][j] = first_match && dp[i+1][j+1];
          }
        }
      }
      return dp[0][0];
    }
}
