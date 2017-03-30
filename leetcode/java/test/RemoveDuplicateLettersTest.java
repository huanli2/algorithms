package test.leetcode;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import main.leetcode.RemoveDuplicateLetters;


@Ignore
public class RemoveDuplicateLettersTest {
  
  private RemoveDuplicateLetters alg = new RemoveDuplicateLetters();
  
  /**
   * "bcabc" --> "abc"
   */
  @Test
  public void test1() {

   Assert.assertEquals(alg.removeDuplicateLetters("bcabc"), "abc");
  }
  
  /**
   * "cbacdcbc" --> "acdb"
   */
  @Test
  public void test2() {
    Assert.assertEquals(alg.removeDuplicateLetters("cbacdcbc"), "acdb");
  }
  
  /**
   * "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws" --> "bfegkuyjorndiqszpcaw"
   */
  @Test
  public void test3() {
    Assert.assertEquals(
        alg.removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"), "bfegkuyjorndiqszpcaw");
  }
}
