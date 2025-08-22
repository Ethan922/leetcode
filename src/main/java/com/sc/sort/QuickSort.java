package com.sc.sort;

public class QuickSort {

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, pivotIndex + 1, right);
            quickSort(nums, left, pivotIndex - 1);
        }
    }

    // 分区并返回基准元素的位置
    public int partition(int[] nums, int left, int right) {
        // 选取最右边的元素作为基准元素
        int pivot = nums[right];
        // low指向小于等于pivot的元素右边界（不包含low）
        int low = left;
        while (left < right) {
            if (nums[left] <= pivot) {
                // 小于pivot的元素移动到左侧
                swap(nums, low, left);
                low++;
            }
            left++;
        }
        // 将基准元素移动到中间
        swap(nums, low, right);
        return low;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5, 6, 1, 4, 9, 5, 0};
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
