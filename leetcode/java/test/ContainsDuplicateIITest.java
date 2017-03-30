package test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.ContainsDuplicateII;

public class ContainsDuplicateIITest {

  private ContainsDuplicateII cls = new ContainsDuplicateII();
  /**
   * nums: [], k:0 return false
   */
  @Test
  public void test1() {
    
    Assert.assertFalse(cls.containsNearbyDuplicate(new int[]{}, 0));
  }
  
  /**
   * nums: [1, 3, 2, 5, 4, 3], k: 2 return false
   */
  @Test
  public void test2() {
    
    Assert.assertFalse(cls.containsNearbyDuplicate(new int[]{1, 3, 2, 5, 4, 3}, 2));
  }
  
  /**
   * nums: [1, 3, 2, 5, 4, 3], k: 4 return true
   */
  @Test
  public void test3() {
    
    Assert.assertTrue(cls.containsNearbyDuplicate(new int[]{1, 3, 2, 5, 4, 3}, 4));
  }
}
