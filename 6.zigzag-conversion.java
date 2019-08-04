/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (32.64%)
 * Total Accepted:    342.8K
 * Total Submissions: 1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
      if (numRows == 1) {
        return s;
      }
      StringBuilder[] sbs = new StringBuilder[numRows];
      for (int i = 0; i < numRows; i++) {
        sbs[i] = new StringBuilder();
      }
      int ind = 0;
      int i = 0, j = 0;
      int flag = -1;
      while (ind < s.length()) {
        // do real thing
        if (i == numRows - 1) {
          flag = 2;
        } else if (i == 0) {
          flag = 1;
        }
        // System.out.println(i + " " + j + " " + s.charAt(ind) + " " + sbs[i]);
        sbs[i].append(s.charAt(ind));
        ind++;
        if (flag == 1) {
          i++;
        } else {
          j++;
          i--;
        }
      }
      StringBuilder ans = new StringBuilder();
      for (StringBuilder sb : sbs) {
        ans.append(sb);
      }
      return ans.toString();
    }
}
