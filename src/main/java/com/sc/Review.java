package com.sc;

import java.util.*;
import java.util.concurrent.Semaphore;

public class Review {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[j] = queue.peek()[0];
        }
        return ans;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int r = 0;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            while (check(sMap, tMap) && l < r) {
                if (r - l + 1 < ans) {
                    ansL = l;
                    ansR = r;
                    ans = r - l + 1;
                }
                sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    public boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character c = entry.getKey();
            Integer count = entry.getValue();
            if (sMap.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null;
        ListNode curr = head;
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = dummy;
        while (count >= k) {
            count -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            ListNode next = p.next;
            next.next = curr;
            p.next = pre;
            p = next;
        }
        return dummy.next;
    }

//    public Node copyRandomList(Node head) {
//        Map<Node, Node> map = new HashMap<>();
//        Node p = head;
//        while (p != null) {
//            map.put(p, new Node(p.val));
//            p = p.next;
//        }
//        for (Node node : map.keySet()) {
//            map.get(node).next = map.get(node.next);
//            map.get(node).random = map.get(node.random);
//        }
//        return map.get(head);
//    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(right);
        return merge(sortedLeft, sortedRight);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode ret = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }
        return ret.next;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer mid = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftIndex = stack.peek();
                int rightIndex = i;
                int width = rightIndex - leftIndex + 1;
                ans += width * (Math.min(height[leftIndex], height[rightIndex]) - height[mid]);

            }
            stack.push(i);
        }
        return ans;
    }

    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Integer i = threadLocal.get();
        threadLocal.set(i);
        threadLocal.remove();
        new Thread(() -> {
            try {
                semaphoreA.acquire();
                Thread.sleep(500);
                System.out.println("A");
                semaphoreB.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                semaphoreB.acquire();
                System.out.println("B");
                semaphoreC.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                semaphoreC.acquire();
                System.out.println("C");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) return false;
        int i;
        for (i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        int j = i + 1;
        if (j >= nums.length - 1) return false;
        for (; j < nums.length - 2; j++) {
            if (nums[j] < nums[j + 1]) {
                break;
            } else if (nums[j] == nums[j + 1]) {
                return false;
            }
        }
        int k = j + 1;
        if (k == nums.length - 1) {
            return nums[k] > nums[k - 1];
        }
        for (; k < nums.length - 1; k++) {
            if (nums[k] > nums[k + 1]) {
                return false;
            } else if (nums[k] == nums[k + 1]) {
                return false;
            }
        }
        return k >= nums.length - 1;
    }

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return ans;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public String decodeString(String s) {
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                multiStack.push(multi);
                multi = 0;
                stack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                int n = multiStack.pop();
                StringBuilder temp = new StringBuilder(stack.pop());
                for (int j = 0; j < n; j++) {
                    temp.append(res);
                }
                res = temp;
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid - 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[r]) {
                if (nums[mid] < target || nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            } else if (target > nums[r]) {
                if (nums[mid] < nums[r] || nums[mid] > target) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else {
                return r;
            }
        }
        return -1;
    }

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
        return nums.length+1;
    }


}
