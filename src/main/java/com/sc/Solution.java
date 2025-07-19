package com.sc;

import java.util.*;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 1};
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] countArr = countChar(str);
            String s = new String(countArr);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1;
            int temp = num;
            while (set.contains(temp + 1)) {
                temp++;
                len++;
            }
            max = Math.max(len, max);
        }
        return max;
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[i++] = nums[k];
            }
        }
        for (int j = i; i < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int width = j - i;
            if (left > right) {
                j--;
            } else {
                i++;
            }
            max = Math.max(max, Math.min(left, right) * width);
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ret.add(list);
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                    while (k > 0 && nums[k] == nums[k - 1]) k--;
                }
            }
        }
        return ret;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] pArr = countChar(p);
        int pLen = p.length();
        int sLen = s.length();
        ArrayList<Integer> ret = new ArrayList<>();
        if (sLen < pLen) {
            return ret;
        }
        for (int i = 0; i < sLen - pLen + 1; i++) {
            String str = s.substring(i, pLen + i);
            char[] strArr = countChar(str);
            if (compareArr(strArr, pArr)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private static boolean compareArr(char[] arr1, char[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static char[] countChar(String str) {
        char[] countArr = new char[26];
        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i) - 'a']++;
        }
        return countArr;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int test(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 1; i < n && j >= 0; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArr = new int[nums.length - k + 1];
        int max = findMax(0, k, nums);
        maxArr[0] = max;
        int j = 1;
        for (int i = 1; i < nums.length - k + 1; i++) {
            // 左边界的前一位是上一个滑动窗口的最大值
            if (max == nums[i - 1] && max != nums[i]) {
                max = findMax(i, k, nums);

            } else {
                // 判断新加入滑动窗口的值和上一个最大值
                max = Math.max(max, nums[i + k - 1]);
            }
            maxArr[j++] = max;
        }
        return maxArr;
    }

    private static int findMax(int start, int n, int[] arr) {
        int max = arr[start];
        for (int i = start + 1; i < start + n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    // 滑动窗口的最大值优先队列解法
    public static int[] maxSlidingWindowByPriorityQueue(int[] nums, int k) {
        int[] maxArr = new int[nums.length - k + 1];
        // 构建大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        maxArr[0] = queue.peek()[0];
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            // 移除堆顶元素，知道堆顶元素（及最大值）的索引在滑动窗口内
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            maxArr[j++] = queue.peek()[0];
        }
        return maxArr;
    }

    // 最小覆盖字串
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        // 滑动窗口中的字符统计map
        Map<Character, Integer> sMap = new HashMap<>();
        // 目标字符串t的字符统计map
        Map<Character, Integer> tMap = new HashMap<>();
        // 统计t中的字符
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // 左指针，指向滑动窗口的左边界
        int l = 0;
        int maxRight = sLen;
        // 预处理s,如果l指向的字符不在tMap内则直接跳过
        for (int i = 0; i < sLen; i++) {
            if (!tMap.containsKey(s.charAt(l))) {
                l++;
            } else {
                break;
            }
        }
        for (int i = sLen - 1; i >= l; i--) {
            if (!tMap.containsKey(s.charAt(i))) {
                maxRight--;
            } else {
                break;
            }
        }
        if (l == s.length()) {
            return "";
        }
        int r = l;
        int minLen = sLen + 1, ansL = -1, ansR = -1;
        while (r < maxRight) {
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            // 滑动窗口包含全部字符
            while (check(sMap, tMap) && l <= r) {
                // 统计最小值
                int curLen = r - l + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    ansL = l;
                    ansR = r;
                }
                // 缩减滑动窗口大小,更新sMap中左边界字符的个数，左指针右移
                sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            r++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    // 比较tMap中的字符是否全包含sMap中的字符
    private static boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character c = entry.getKey();
            Integer cnt = entry.getValue();
            if (sMap.getOrDefault(c, 0) < cnt) {
                return false;
            }
        }
        return true;
    }

    //        // 计算前缀和
//        int[] prefixSum = new int[nums.length];
//        prefixSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            prefixSum[i] = prefixSum[i - 1] + nums[i];
//        }

    // BF:最大子数组和
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 暴力解法
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // DP:最大子数组和
    public static int maxSubArrayDP(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayDP(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(minWindow("nnnnabcnnn", "cba"));
//        int[] nums = maxSlidingWindow(new int[]{4, -2}, 2);
//        for (int num : nums) {
//            System.out.println(num);
//        }
    }
}
