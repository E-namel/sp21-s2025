package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> testBuggyAList = new BuggyAList<>();
        AListNoResizing<Integer> testAListNoResizing = new AListNoResizing<>();

        int[] values = {4, 5, 6};
        for (int v : values) {
            testBuggyAList.addLast(v);
            testAListNoResizing.addLast(v);
        }

        for (int i = 0; i < values.length; i++) {
            assertEquals(testBuggyAList.removeLast(), testAListNoResizing.removeLast());
        }

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0:
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    B.addLast(randVal);
                    break;
                case 1:
                    // size
                    assertEquals(L.size(), B.size());
                    break;
                case 2:
                    // removeLast
                    if (L.size() > 0 || B.size() > 0) {
                        assertEquals(L.removeLast(), B.removeLast());
                    }
                    break;
                case 3:
                    // getLast
                    if (L.size() > 0 || B.size() > 0) {
                        assertEquals(L.getLast(), B.getLast());
                    }
                    break;
            }
        }
    }
}
