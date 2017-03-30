package test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.RemoveKDigits;

public class RemoveKDigitsTest {

  private RemoveKDigits cls = new RemoveKDigits();
  /**
   * Input: num = "1432219", k = 3
   * Output: "1219"
   */
  @Test
  public void test1() {
    
    Assert.assertEquals(cls.removeKdigits("1432219", 3), "1219");
  }
  
  /**
   * Input: num = "10200", k = 1
   * Output: "200"
   */
  @Test
  public void test2() {
    
    Assert.assertEquals(cls.removeKdigits("10200", 1), "200");
  }
  
  /**
   * Input: num = "10", k = 2
   * Output: "0"
   */
  @Test
  public void test3() {
    
    Assert.assertEquals(cls.removeKdigits("10", 2), "0");
  }
  
  /**
   * Input: num = "10", k = 1
   * Output: "0"
   */
  @Test
  public void test4() {
    
    Assert.assertEquals(cls.removeKdigits("10", 1), "0");
  }
  
  /**
   * Input: num = "112", k = 1
   * Output: "12"
   */
  @Test
  public void test5() {
    
    Assert.assertEquals(cls.removeKdigits("112", 1), "11");
  }
}
