package main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * @author lih
 *
 */
public class ContainsDuplicateII {
  
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int size = nums.length;
    
    for (int i = 0; i < size; ++i) {
      Integer num = nums[i];
      Integer value = map.get(num);
           
      if (value != null && i - value <= k) {
        
        return true;
      } else {
        map.put(num, i);
      }
    }
    
    return false;
  }
}
