package main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * @author lih
 *
 */
public class FractionToRecurringDecimal {

  public String fractionToDecimal(int numerator, int denominator) {
    
    if (numerator == 0) return "0";
    
    long num = numerator;

    long den = denominator;
    
    boolean isNegtive = (num < 0 || den < 0) && (num > 0 || den > 0);
    num = Math.abs(num);
    den = Math.abs(den);
    long originNumerator = num;
    
    StringBuilder result = new StringBuilder();
    Map<Long, Integer> numerators = new HashMap<>();
  
    while (num != 0) {
      
      long r = num / den;
      result.append(r);
      numerators.put(num, result.length());
      num = (num - den * r) * 10;
      
      //divide over
      if (num == 0) break; 
      //loop
      if (numerators.containsKey(num)) break;
    }
    
    if (num != 0) {
      result.insert(numerators.get(num).intValue() - 1, '(');
      result.append(')');
    }
    
    if (numerators.size() > 1) {
      result.insert(numerators.get(originNumerator).intValue(), '.');
    }
    
    if (isNegtive) {
      result.insert(0, "-");
    }
    
    return result.toString();
  }
}
