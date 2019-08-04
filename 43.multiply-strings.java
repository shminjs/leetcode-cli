/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (31.17%)
 * Total Accepted:    214.1K
 * Total Submissions: 686.4K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
       int[] res = new int[num1.length() + num2.length() + 1];
       String swap = null;
       if (num1.length() < num2.length()) {
         swap = num2;
         num2 = num1;
         num1 = swap;
       }
       for (int j = num2.length() - 1; j >= 0; j--) {
         for (int i = num1.length() - 1; i >= 0; i--) {
           int ans = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
           res[i + j + 2] += ans;
         }
       }
       // System.out.println(Arrays.toString(res));
       int acc = 0;
       for (int k = res.length - 1; k >= 0; k--) {
         res[k] += acc;
         acc = res[k] / 10;
         res[k] = res[k] % 10;
       }
       StringBuilder sb = new StringBuilder();
       boolean flag = false;
       for (int i = 0; i < res.length; i++) {
         if (res[i] != 0 || flag) {
           sb.append(res[i]);
           flag = true;
         }
       }
       String last = sb.toString();
       if (last.equals("")) {
         return "0";
       } else {
         return last;
       }
    }
}
