import komal.comapnyInterviews.ClearTaxAssignment;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ClearTaxTest {

    @Test
    public void manipulationCount() throws IOException {
        ClearTaxAssignment.fileExtraction();
        assertEquals((long)2,(long)ClearTaxAssignment.getBucket(31));
        assertEquals((long)3,(long)ClearTaxAssignment.getBucket(51));

    }



}