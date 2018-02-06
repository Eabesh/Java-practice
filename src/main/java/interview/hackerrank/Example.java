package interview.hackerrank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by abhay on 03/02/18.
 */
public class Example {
  static class A extends Thread{
    int count = 0;
    public void run(){
      System.out.println("run");
      synchronized (this) {
        for(int i =0; i < 50 ; i++){
          count = count + i;
        }
        notify();
      }
    }
  }


}
