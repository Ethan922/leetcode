package com.sc;

import java.util.*;

public class Solution {

    // 两数之和
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

    // 字母异位次分组
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

    // 字母异位次分组
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


    // 最长连续序列
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

    // 移动零
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

    // 盛水最多的容器
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

    // 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 去重
            if (i != 0 && nums[i] == nums[i - 1]) {
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

    // 接雨水
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

    // 无重复字符的最长子串
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

    // 找到字符串中所有字母异位词
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

    // 和为k的子数组
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

    // 滑动窗口的最大值
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

    // 最小覆盖子串
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

    // 合并区间
    public int[][] merge(int[][] intervals) {
        // 按照左端点排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        List<int[]> ret = new ArrayList<>();
        ret.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = ret.get(ret.size() - 1);
            if (intervals[i][0] <= pre[1]) {
                pre[1] = Math.max(pre[1], intervals[i][1]);
            } else {
                ret.add(intervals[i]);
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    private void reverseArr(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        R[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
            R[nums.length - i - 1] = R[nums.length - i] * nums[nums.length - i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            L[i] = L[i] * R[i];
        }
        return L;
    }

    // 除自身以外数组的乘积(优化空间复杂度)
    public int[] productExceptSelfO1(int[] nums) {
        int[] L = new int[nums.length];
        int R = 1;
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            L[i] = L[i] * R;
            R *= nums[i];
        }
        return L;
    }

    // 缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    // 矩阵置零
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] index : list) {
            int row = index[0];
            int col = index[1];
            Arrays.fill(matrix[row], 0);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    // 矩阵置零(优化空间复杂度)
    public void setZeroesO1(int[][] matrix) {
        // 标记第一行是否有零
        boolean firstRow = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        // 标记第一列是否有零
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        // 用首行和首列标记
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] direction = new int[4][2];
        direction[0] = new int[]{0, 1};
        direction[1] = new int[]{1, 0};
        direction[2] = new int[]{0, -1};
        direction[3] = new int[]{-1, 0};
        List<Integer> list = new ArrayList<>();
        int index = 0;
        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0;
        for (int i = 0; i < m * n; i++) {
            visited[row][col] = true;
            int nextRow = row + direction[index][0], nextCol = col + direction[index][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || visited[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            list.add(matrix[row][col]);
            row += direction[index][0];
            col += col + direction[index][1];
        }
        return list;
    }

    // 旋转矩阵
    public void rotate(int[][] matrix) {
        // 水平翻转
        int up = 0;
        int down = matrix.length - 1;
        while (up < down) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[up][j];
                matrix[up][j] = matrix[down][j];
                matrix[down][j] = temp;
            }
            up++;
            down--;
        }
        // 主对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    // 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
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
