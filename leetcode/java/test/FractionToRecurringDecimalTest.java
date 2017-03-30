package test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.FractionToRecurringDecimal;

public class FractionToRecurringDecimalTest {

  private FractionToRecurringDecimal solution = new FractionToRecurringDecimal();
  /**
   * Given numerator = 1, denominator = 2, return "0.5".
   */
  @Test
  public void test1() {

    Assert.assertEquals(solution.fractionToDecimal(1, 2), "0.5");
  }
  
  /**
   * Given numerator = 2, denominator = 1, return "2".
   */
  @Test
  public void test2() {
    
    Assert.assertEquals(solution.fractionToDecimal(2, 1), "2");
  }
  
  /**
   * Given numerator = 1, denominator = 20, return "0.05".
   */
  @Test
  public void test3() {
    
    Assert.assertEquals(solution.fractionToDecimal(1, 20), "0.05");
  }
  
  /**
   * Given numerator = 2, denominator = 3, return "0.(6)".
   */
  @Test
  public void test4() {
    
    Assert.assertEquals(solution.fractionToDecimal(2, 3), "0.(6)");
  }
  
  /**
   * Given numerator = 4, denominator = 333, return "0.(012)".
   */
  @Test
  public void test5() {
    
    Assert.assertEquals(solution.fractionToDecimal(4, 333), "0.(012)");
  }
  
  /**
   * Given numerator = 0, denominator = 3, return "0".
   */
  @Test
  public void test6() {
    Assert.assertEquals(solution.fractionToDecimal(0, 3), "0");
  }
  
  /**
   * Given numerator = 22, denominator = 7, return "3.(142857)".
   */
  @Test
  public void test7() {
    Assert.assertEquals(solution.fractionToDecimal(22, 7), "3.(142857)");
  }
  
  /**
   * Given numerator = -50, denominator = 8, return "-6.25".
   */
  @Test
  public void test8() {
    
    Assert.assertEquals(solution.fractionToDecimal(-50, 8), "-6.25");
  }
  
  /**
   * Given numerator = -50, denominator = -8, return "6.25".
   */
  @Test
  public void test9() {
    
    Assert.assertEquals(solution.fractionToDecimal(50, 8), "6.25");
  }
  
  /**
   * Given numerator = -1, denominator = -2147483648, return "0.0000000004656612873077392578125".
   */
  @Test
  public void test10() {
    
    Assert.assertEquals(solution.fractionToDecimal(-1, -2147483648), "0.0000000004656612873077392578125");
  }
  
  /**
   * Given numerator = 2147483647, denominator = 37, return "58040098.(567)".
   */
  @Test
  public void test11() {
    
    Assert.assertEquals(solution.fractionToDecimal(2147483647, 37), "58040098.(567)");
  }
}
