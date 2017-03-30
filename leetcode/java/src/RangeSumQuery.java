package main.leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * @author lih
 *
 */
public class RangeSumQuery {
  
  private int[] nums;
  private int size;
  
  public RangeSumQuery(int[] nums) {
    
    this.nums = nums;
    this.size = nums.length;
  }

  public void update(int i, int val) {
    if (i < 0 || i >= size) return;
    nums[i] = val;
  }
  
  public int sumRange(int i, int j) {
    i = max(i, 0);
    j = min(j, size - 1);
    
    int result = 0;
    for (int s = i; s <= j; ++s) {
      result += nums[s];
    }
    
    return result;
  }
  
  private int max(int a, int b) {
    return a < b ? b : a;
  }
  
  private int min(int a, int b) {
    return a < b ? a : b;
  }
}
