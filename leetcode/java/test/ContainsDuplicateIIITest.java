
package test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.ContainsDuplicateIII;

public class ContainsDuplicateIIITest {

  private ContainsDuplicateIII cls = new ContainsDuplicateIII();
  
  /**
   * nums: [], k:0, t:0 return false
   */
  @Test
  public void test1() {
    
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate(new int[]{}, 0, 0));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate1(new int[]{}, 0, 0));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate2(new int[]{}, 0, 0));
  }
  
  /**
   * nums: [1, 3, 2, 5, 4, 3], k: 2, t:0 return false
   */
  @Test
  public void test2() {
    
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate(new int[]{1, 3, 2, 5, 4, 3}, 2, 0));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate1(new int[]{1, 3, 2, 5, 4, 3}, 2, 0));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate2(new int[]{1, 3, 2, 5, 4, 3}, 2, 0));
  }
  
  /**
   * nums: [1, 3, 2, 5, 4, 3], k: 4, t: 0 return true
   */
  @Test
  public void test3() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{1, 3, 2, 5, 4, 3}, 4, 0));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{1, 3, 2, 5, 4, 3}, 4, 0));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{1, 3, 2, 5, 4, 3}, 4, 0));
  }
  
  /**
   * nums: [1, 3, 2, 5, 4, 3], k: 2, t: 1 return true
   */
  @Test
  public void test4() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{1, 3, 2, 5, 4, 3}, 4, 1));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{1, 3, 2, 5, 4, 3}, 4, 1));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{1, 3, 2, 5, 4, 3}, 4, 1));
  }
  
  /**
   * nums: [-3, 3], k: 2, t: 4 return false
   */
  @Test
  public void test5() {
    
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate1(new int[]{-3, 3}, 2, 4));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate2(new int[]{-3, 3}, 2, 4));
  }
  
  /**
   * nums: [0,2147483647], k: 1, t:2147483647 return true
   */
  @Test
  public void test6() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 2, 2147483647));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{0,2147483647}, 2, 2147483647));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{0,2147483647}, 2, 2147483647));
  }
  
  /**
   * nums: [-1, -1], k: 1, t:0 return true
   */
  @Test
  public void test7() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{-1, -1}, 1, 0));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{-1, -1}, 1, 0));
  }
  
  /**
   * nums: [7, 2, 8], k: 2, t:1 return true
   */
  @Test
  public void test8() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{7, 2, 8}, 2, 1));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{7, 2, 8}, 2, 1));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{7, 2, 8}, 2, 1));
  }
  
  /**
   * nums: [3, 6, 0, 2], k: 2, t:2 return true
   */
  @Test
  public void test9() {
    
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 2}, 2, 2));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate1(new int[]{3, 6, 0, 2}, 2, 2));
    Assert.assertTrue(cls.containsNearbyAlmostDuplicate2(new int[]{3, 6, 0, 2}, 2, 2));
  }
  
  /**
   * nums: [0,2147483647], k: 1, t:3 return true
   */
  @Test
  public void test10() {
    
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 2, 3));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate1(new int[]{0,2147483647}, 2, 3));
    Assert.assertFalse(cls.containsNearbyAlmostDuplicate2(new int[]{0,2147483647}, 2, 3));
  }
}
