package com.bigdou.school.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <P>文件描述：字符串Demo</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-1 14:12:12
 */
public class StringDemo {

    public static int lengthOfLongestSubstring(String s) {
        s = "abcaaabbbccccqweqw";
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("");
    }

}
