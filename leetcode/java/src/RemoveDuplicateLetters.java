package main.leetcode;

public class RemoveDuplicateLetters {
  
  /**
   * 可用方案，递归复杂度太高，执行太慢
   * @param s
   * @return
   */
  public String removeDuplicateLetters(String s) {
    
    Integer arr[] = new Integer[26];
    
    for (int i = 0; i < s.length(); ++i) {
      int index = s.charAt(i) - 'a';
      
      if (arr[index] == null) {
        arr[index] = i;
      }
      else {
        String s1 = removeDuplicateLetters(s.substring(0, arr[index]) + s.substring(arr[index] + 1));
        String s2 = removeDuplicateLetters(s.substring(0, i) + s.substring(i + 1));
        
        return s1.compareTo(s2) > 0 ? s2 : s1;
      }
    }
      
    return s;
  } 
  

}
