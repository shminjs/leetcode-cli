/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.64%)
 * Total Accepted:    1M
 * Total Submissions: 3.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * Input: "pkkkew" 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() == 0) {
        return 0;
      }
      int[] map = new int[256];
      int left = 0, right = 0;
      int ans = 0;
      while (left <= right && right < s.length()) {
        if (map[s.charAt(right) - '\0'] != 0) {
          // System.out.println(left + " " + right + " " + s.charAt(right));
          ans = Math.max(ans, right - left);
          while (s.charAt(left) != s.charAt(right)) {
            map[s.charAt(left) - '\0']--;
            left++;
          }
          left++;
          right++;
        } else {
          map[s.charAt(right) - '\0']++;
          right++;
        }
      }
      ans = Math.max(ans, right - left);
      return ans;
    }
}
