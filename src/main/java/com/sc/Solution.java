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
        int r = l;
        int minLen = sLen + 1, ansL = -1, ansR = -1;
        while (r < sLen) {
            if (!tMap.containsKey(s.charAt(r))) {
                r++;
                continue;
            }
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

    // 搜索二维矩阵II
    public boolean searchMatrixII(int[][] matrix, int target) {
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
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 回文链表
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list = reverseList(slow);
        ListNode p = head;
        while (p != null && list != null) {
            if (p.val != list.val) {
                return false;
            }
            p = p.next;
            list = list.next;
        }
        return true;
    }

    // 环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 环形链表II
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (slow != p) {
                    slow = slow.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ret = new ListNode(0);
        ListNode list = ret;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                list.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                list.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            list = list.next;
        }
        if (p1 == null) {
            list.next = p2;
        }
        if (p2 == null) {
            list.next = p1;
        }
        return ret.next;
    }

    // 两数之和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while (p1 != null || p2 != null) {
            p1 = p1 == null ? new ListNode(0) : p1;
            p2 = p2 == null ? new ListNode(0) : p2;
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return ret.next;
    }

    // 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head.next == null) {
//            return null;
//        }
//        ListNode p = head;
//        for (int i = 0; i < n; i++) {
//            p = p.next;
//        }
//        if (p == null) {
//            return head.next;
//        }
//        ListNode p1 = head;
//        while (p.next != null) {
//            p = p.next;
//            p1 = p1.next;
//        }
//        p1.next = p1.next.next;
//        return head;
        if (head.next == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        ListNode p1 = dummyNode;
        while (p.next != null) {
            p = p.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return dummyNode.next;
    }

    // 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    // 跳跃游戏
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 判断当前位置是否可达
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    // 只出现一次的数字
    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    // 寻找重复数
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (nums[slow] != nums[fast]);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 长度最小的子数组
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target && l <= r) {
                minLen = Math.min(r - l + 1, minLen);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // 乘积小于k的子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int product = 1;
        int count = 0;
        while (r < nums.length) {
            product *= nums[r];
            while (product >= k && l <= r) {
                product /= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    // 二分查找（查找有序数组中第一个大于等于target的元素下标）
    public int binSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int first = binSearch(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, 1};
        }
        int last = binSearch(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    // 寻找峰值
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    // k个一组反转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode curr = p0.next;
        while (count >= k) {
            count -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            ListNode next = p0.next;
            p0.next.next = curr;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }

    // 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseKGroup(head, 2);
    }

    // 随机链表的复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Integer> map = new HashMap<>();
        HashMap<Integer, Node> map1 = new HashMap<>();
        Node p1 = head;
        Node ret = new Node(0);
        Node p2 = ret;
        int index = 0;
        while (p1 != null) {
            p2.next = new Node(p1.val);
            p2 = p2.next;
            map.put(p1, index);
            map1.put(index, p2);
            index++;
            p1 = p1.next;
        }
        // 记录随机节点的索引
        List<Integer> randomNodeIndexList = new ArrayList<>();
        p1 = head;
        while (p1 != null) {
            randomNodeIndexList.add(map.get(p1.random));
            p1 = p1.next;
        }
        p2 = ret.next;
        for (Integer randomNodeIndex : randomNodeIndexList) {
            p2.random = map1.get(randomNodeIndex);
            p2 = p2.next;
        }
        return ret.next;
    }

    // 随机链表的复制(优化)
    public Node copyRandomListOptimize(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node p1 = head;
        while (p1 != null) {
            map.put(p1, new Node(p1.val));
            p1 = p1.next;
        }
        p1 = head;
        while (p1 != null) {
            map.get(p1).next = map.get(p1.next);
            map.get(p1).random = map.get(p1.random);
            p1 = p1.next;
        }
        return map.get(head);
    }

    // 排序链表
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode p = head;
        while (p != null) {
            queue.offer(p);
            p = p.next;
        }
        ListNode ret = new ListNode(0);
        p = ret;
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
        }
        p.next = null;
        return ret.next;
    }

    // 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        for (ListNode list : lists) {
            ret = mergeTwoLists(ret, list);
        }
        return ret;
    }

    private List<Integer> ret = new ArrayList<>();

    // 二叉树的中序遍历 递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ret;
        }
        inorderTraversal(root.left);
        ret.add(root.val);
        inorderTraversal(root.right);
        return ret;
    }

    // 二叉树的中序遍历 迭代写法
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }

    // 二叉树的最大深度 递归写法
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 二叉树的最大深度 迭代写法
    public int maxDepthIteration(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    // 翻转二叉树 递归写法
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    // 翻转二叉树 迭代写法
    public TreeNode invertTreeIteration(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(list);
        }
        return ans;
    }

    // 对称二叉树 递归写法
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, left.right) && check(right.left, right.right);
    }

    // 对称二叉树 迭代写法
    public boolean isSymmetricIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }

    int ans = 0;

    // 二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

    // 验证二叉搜索树 递归写法
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 验证二叉搜索树 迭代写法
    public boolean isValidBSTIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double rootVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val < rootVal) {
                return false;
            }
            rootVal = root.val;
            root = root.right;
        }
        return true;
    }

    // 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        // 二叉搜索树的中序遍历结果是升序的
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l < r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);
        return node;
    }

    // 二叉搜索树中第 K 小的元素
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 1;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (count == k) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }

    // 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (size == 1) {
                    ans.add(node.val);
                }
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    // 二叉树展开为链表
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode ans = new TreeNode();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.right = node;
            ans.left = null;
            ans = node;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        root = ans.right;
    }

    Map<Integer, Integer> map = new HashMap<>();

    // 从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int rootIndex = map.get(preorder[preorderLeft]);
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        root.left = buildTree(preorder, inorder, preorderLeft + 1, rootIndex - inorderLeft + preorderLeft, inorderLeft, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + rootIndex - inorderLeft + 1, preorderRight, rootIndex + 1, inorderRight);
        return root;
    }

    // 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int l = 0, r = total - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] > target) {
                r = mid - 1;
            } else if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // 搜索插入的位置
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    // 寻找旋转排序数组中的最小值
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }

    // 重排链表
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseListForReorder(slow);
        ListNode head1 = head;
        while (head2.next != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }

    private ListNode reverseListForReorder(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点为空或为p或为q，返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归查找左右子树中的p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树中都查找到，则当前节点是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 左子树中查找到，右子树中未查到，则最近公共祖先是左子树递归的结果
        if (left != null) {
            return left;
        }
        // 左子树中未查到，右子树中查找到，则最近公共祖先是右子树递归的结果
        return right;
    }

    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
//        System.out.println(maxSubArrayDP(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(minWindow("nnnnabcnnn", "cba"));
//        int[] nums = maxSlidingWindow(new int[]{4, -2}, 2);
//        for (int num : nums) {
//            System.out.println(num);
//        }
    }
}
