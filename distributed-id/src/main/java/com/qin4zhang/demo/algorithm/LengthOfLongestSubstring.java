package com.qin4zhang.demo.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author zhangzhen
 * @date 2021/8/23 下午10:41
 **/
public class LengthOfLongestSubstring {
    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 存放的是不重复的字符的下标
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 如果map中包含了字符，这说明有重复字符出现，此时要将左指针移动位置
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // 如果有重复字符，则更新字符对应的下标，如果没有，则新增字符的下标
            map.put(s.charAt(right), right);
            // 右指针 - 左指针 + 1 表示的是字符串的长度
            max = Math.max(max, right - left + 1);
        }
        return max;

    }


    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1("bbbbb"));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1("pwwkew"));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1(""));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("abcabbcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(""));
    }

}
