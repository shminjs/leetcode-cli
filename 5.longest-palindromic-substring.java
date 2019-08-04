/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.65%)
 * Total Accepted:    610.1K
 * Total Submissions: 2.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
      if (s.length() == 0) {
        return "";
      }
      String ans = "";
      for (int i = 0; i < s.length(); i++) {
        String t1 = palindrome(s, i, i);
        if (t1.length() > ans.length()) {
          ans = t1;
        }
        String t2 = palindrome(s, i, i+1);
        if (t2.length() > ans.length()) {
          ans = t2;
        }
      }
      return ans;
    }

    public String palindrome(String s, int left, int right) {
      while (left >= 0 && right < s.length()) {
        if (s.charAt(left) == s.charAt(right)) {
          left--;
          right++;
        } else {
          break;
        }
      }
      return s.substring(left+1, right);
    }
}
