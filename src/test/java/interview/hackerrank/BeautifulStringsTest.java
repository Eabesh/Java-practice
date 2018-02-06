package interview.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 03/02/18.
 */
public class BeautifulStringsTest {
  @Test
  public void beautifulString() throws Exception {
//    new BeautifulStrings().beautifulString("aeiou", 3, "", 0);

    System.out.println(new BeautifulStrings().countBeautifulString("aeiou", 6, 0));
  }

}