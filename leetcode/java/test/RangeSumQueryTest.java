package test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.RangeSumQuery;

public class RangeSumQueryTest {

  
  /**
   * Given nums = [1, 3, 5]

   * sumRange(0, 2) -> 9
   * update(1, 2)
   * sumRange(0, 2) -> 8
   */
  @Test
  public void test() {
    int[] nums = new int[]{1, 3, 5};
    
    RangeSumQuery rs = new RangeSumQuery(nums);
    
    Assert.assertEquals(rs.sumRange(0, 2), 9);
    
    rs.update(1, 2);
    Assert.assertEquals(rs.sumRange(0, 2), 8);
  }
}
