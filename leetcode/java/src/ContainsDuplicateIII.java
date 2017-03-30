package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 * @author lih
 *
 */
public class ContainsDuplicateIII {
  
  /**
   * my answer with range list O(nlogn)
   * range list maintains the available values of nums with the biggest index
   * @param nums
   * @param k
   * @param t
   * @return
   */
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    
    List<Item> items = new ArrayList<>();
    int size = nums.length;
    
    for (int i = 0; i < size; ++i) {
      int value = nums[i];
      int sIndex = findNearestSmallerIndex(items, value);
      if (sIndex >= 0 && i - items.get(sIndex).index <= k) {
        
        Item item = items.get(sIndex);
        if (value >= item.rangeBegin && value <= item.rangeEnd) {
          return true;
        }      
      }
      insertItem(items, new Item(i, value - t, value + t));
    }
    
    return false;
  }
  
  private int findNearestSmallerIndex(List<Item> items, int rangeBegin) {
    
    if (items.isEmpty() || items.get(0).rangeBegin > rangeBegin) return -1;
    
    int right = items.size() - 1;
    int left = 0;
    
    while (right > left + 1) {
      int center = (right + left) / 2;
      if (items.get(center).rangeBegin >= rangeBegin) {
        
       right = center; 
      } else {
        
        left = center;
      }
    }
    return items.get(right).rangeBegin <= rangeBegin ? right : left;
  }
  
  private void insertItem(List<Item> items, Item item) {
    
    int rb = item.rangeBegin;
    int re = item.rangeEnd;
    
    int smallestIndex = findNearestSmallerIndex(items, rb);
    if(smallestIndex >= 0) {
      Item rbi = items.get(smallestIndex);
      if (rb <= rbi.rangeEnd) {
 
        rbi.rangeEnd = rb - 1;
      } 
      if (rbi.rangeEnd < rbi.rangeBegin) {
        items.remove(smallestIndex);
        --smallestIndex;
      }
    }
    
    int nearBiggerIndex = smallestIndex + 1;
    if (nearBiggerIndex < items.size()) {
      Item rbi = items.get(nearBiggerIndex);
      int rbb = rbi.rangeBegin;
      int reb = rbi.rangeEnd;     
      if (re >= reb) {
        
        items.remove(nearBiggerIndex);
      } else if (re >= rbb) {
        
        rbi.rangeBegin = re + 1;
      } 
    }
    items.add(nearBiggerIndex, item);
  }
  
  private class Item {
    
    private int index;
    
    private int rangeBegin;
    
    private int rangeEnd;
    
    Item(int index, int rangeBegin, int rangeEnd) {
      this.index = index;
      this.rangeBegin = rangeBegin;
      this.rangeEnd = rangeEnd;
    }
  }
  /**
   * other people answer with bucket O(n)
   * bucket size: t, at most k bucket(indices <= k)
   * 落桶一定命中，不落桶在误差范围内命中，否则一定不命中
   * i - k之前落桶的元素一定无效
   * 减 MIN是为了均匀落桶
   * @param nums
   * @param k
   * @param t
   * @return
   */
  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    
    if (k < 1 || t < 0) return false;
    
    Map<Long, Long> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
      
        long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
        long bucket = remappedNum / ((long) t + 1);
        
        //防止求余误差
        if (map.containsKey(bucket)
                || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
          
          return true;
        }
                        
        if (map.entrySet().size() >= k) {
          
            long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
            map.remove(lastBucket);
        }
        map.put(bucket, remappedNum);
    }
    return false;
  }
  
  /**
   * other people's answer with treeSet O(nlogk)
   * 使用tree保存最大最小范围
   * 一定不满足条件的节点直接删除
   * @param nums
   * @param k
   * @param t
   * @return
   */
  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

    if (nums == null || nums.length == 0 || k <= 0) {
        return false;
    }

    final TreeSet<Integer> values = new TreeSet<>();
    for (int ind = 0; ind < nums.length; ind++) {

        final Integer floor = values.floor(nums[ind] + t);
        final Integer ceil = values.ceiling(nums[ind] - t);
        if ((floor != null && floor >= nums[ind])
                || (ceil != null && ceil <= nums[ind])) {
            return true;
        }

        values.add(nums[ind]);
        if (ind >= k) {
            values.remove(nums[ind - k]);
        }
    }

    return false;
}
}
