package data.structures.advanced.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class ADSExamplesTest {

  @Test
  public void printTour() {
    ADSExamples.petrolPump[] arr = {new ADSExamples().new petrolPump(4, 6),
            new ADSExamples().new petrolPump(6, 5),
            new ADSExamples().new petrolPump(7, 3),
    new ADSExamples().new petrolPump(7, 3)};

    int start = new ADSExamples().printTour(arr, arr.length);

    System.out.println(start == -1 ? "No Solution" : "Start = " + start);
  }
}