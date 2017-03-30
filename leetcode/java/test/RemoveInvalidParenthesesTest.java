package test.leetcode;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.leetcode.RemoveInvalidParentheses;

public class RemoveInvalidParenthesesTest {

  private RemoveInvalidParentheses alg = new RemoveInvalidParentheses();
  
  /**
   * "()())()" -> ["()()()", "(())()"]
   */
  @Test
  public void test1() {
    
    List<String> result = alg.removeInvalidParentheses("()())()");
    Assert.assertEquals(result.size(), 2);
    Assert.assertTrue(result.indexOf("()()()") >= 0);
    Assert.assertTrue(result.indexOf("(())()") >= 0);
  }
  
  /**
   * "(a)())()" -> ["(a)()()", "(a())()"]
   */
  @Test
  public void test2() {
    List<String> result = alg.removeInvalidParentheses("(a)())()");
    Assert.assertEquals(result.size(), 2);
    Assert.assertTrue(result.indexOf("(a)()()") >= 0);
    Assert.assertTrue(result.indexOf("(a())()") >= 0);
  }
  
  /**
   * ")(" -> [""]
   */
  @Test
  public void test3() {
    List<String> result = alg.removeInvalidParentheses(")(");
    Assert.assertEquals(result.size(), 1);
    Assert.assertTrue(result.get(0).length() == 0);
  }
}
