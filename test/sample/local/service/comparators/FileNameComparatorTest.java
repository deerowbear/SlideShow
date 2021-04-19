package sample.local.service.comparators;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FileNameComparatorTest extends TestCase {

    FileNameComparator comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new FileNameComparator();
        comparator.setAscending(Boolean.TRUE);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testComparator(){
        File file1 = new File("../src/sample/resources/images/bb.jpg");
        File file2 = new File("../src/sample/resources/images/aa.jpg");
        int result = comparator.compare(file1, file2);
        assertTrue("AA is greater than BB", result >= 1);
    }

}