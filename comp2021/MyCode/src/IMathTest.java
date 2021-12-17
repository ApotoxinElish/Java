import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class to test the class IMath.
 */
public class IMathTest {
    /**
     * Test isqrt.
     */
    @Test
    public void testIsqrt0() {
        assertEquals("...", 0, IMath.isqrt(0));
    }

    @Test
    public void testIsqrt1() {
        assertEquals("...", 1, IMath.isqrt(1));
    }

    @Test
    public void testIsqrt2() {
        assertEquals("...", 1, IMath.isqrt(2));
    }

}