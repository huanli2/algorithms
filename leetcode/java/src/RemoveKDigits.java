package main.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a non-negative integer num represented as a string, remove k digits from 
 * the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * @author lih
 *
 * O(10(n - k))
 */
public class RemoveKDigits {
  
  public String removeKdigits(String num, int k) {
    int size = num.length(); 
    if (size <= k) return "0";
    
    Map<Integer, Queue<Integer> > bucket = new HashMap<>();
    for (int i = 0; i < size; ++i) {
      
      int ch = num.charAt(i);
      
      Queue<Integer> indexs = bucket.get(ch);
      if (indexs == null) {
        indexs = new LinkedList<Integer>();
        bucket.put(ch, indexs);
      }
      indexs.offer(i);
    }
    
    StringBuilder result = new StringBuilder();
    int begin = 0;
    int end = k;
    
    while (begin < end && end < size) {
      
      for (int i = '0'; i <= '9'; ++i) {
        
        Queue<Integer> indexs = bucket.get(i);
        
        if (indexs == null || indexs.isEmpty()) continue;
        
        while (!indexs.isEmpty() && indexs.element() < begin) indexs.poll();
        
        if (!indexs.isEmpty() && indexs.element() <= end) {
          
          result.append((char)i);
          begin = indexs.poll() + 1;
          ++end;
          break;
        }
      }
    }
    
    result.append(num.substring(end));
    
    while(result.length() > 0 && result.charAt(0) == '0') {
      result.deleteCharAt(0);
    }
    
    return result.length() > 0 ? result.toString() : "0";
  }
}
