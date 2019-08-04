/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.88%)
 * Total Accepted:    139.9K
 * Total Submissions: 585.5K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 先找到所有合适的起点
 * 再从该起点开始，使用Trie树递归搜索即可
 * 果然有重复数字，所以需要针对该种情况优化
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      Map<String, Integer> uniques = new HashMap<>();
      for (String word : words) {
        if (!uniques.containsKey(word)) {
          uniques.put(word, 1);
        } else {
          uniques.put(word, uniques.get(word) + 1);
        }
      }
      Set<Integer> starts = new HashSet<>();
      for (Map.Entry<String, Integer> entry : uniques.entrySet()) {
        starts.addAll(searchAllMatchIndices(s, entry.getKey(), words.length));
      }
      // System.out.println(starts);
      List<Integer> res = new ArrayList<>();
      boolean[] visited = new boolean[words.length];
      for (Integer start : starts) {
        int cur = 0;
        if (isConcatenationPro(s, start, uniques, cur, words.length)) {
          res.add(start);
        }
      }
      return res;
    }

    private boolean isConcatenationPro(String s, int start, Map<String, Integer> uniques, int cur, int size) {
      if (cur == size) {
        return true;
      } else {
        boolean res = false;
        for (Map.Entry<String, Integer> entry : uniques.entrySet()) {
          int count = entry.getValue();
          if (count > 0) {
            String word = entry.getKey();
            if (start + word.length() <= s.length() && s.substring(start, start + word.length()).equals(word)) {
              uniques.put(word, --count);
              res = isConcatenationPro(s, start + word.length(), uniques, cur + 1, size);
              uniques.put(word, ++count);
              if (res) {
                return res;
              }
            } 
          }
        }
        return res;
      }
    }

    private boolean isConcatenation(String s, String[] words, int start, int cur, boolean[] visited) {
      if (cur == words.length) {
        return true;
      } else {
        for (int i = 0; i < words.length; i++) {
          if (!visited[i]) {
            if (start + words[i].length() <= s.length() && s.substring(start, start + words[i].length()).equals(words[i])) {
              visited[i] = true;
              return isConcatenation(s, words, start + words[i].length(), cur + 1, visited);
            }
          }
        }
        return false;
      }
    }

    private List<Integer> searchAllMatchIndices(String s, String word, int n) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i <= s.length() - word.length() && i <= s.length() - word.length() * n; i++) {
        if (s.substring(i, i + word.length()).equals(word)) {
          res.add(i);
        }
      }
      return res;
    }
}
