import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import java.util.Iterator;
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ComplexTest {
    @Test
    public void testCreate() {
        Complex c1 = new Complex(6.3, -2.2);
        assertEquals(6.3, c1.getReal());
        assertEquals(-2.2, c1.getImaginary());
    }

    @Test
    public void testNegate() {
        Complex c1 = new Complex(6.3, -2.2);
        c1.negate();
        assertEquals(-6.3, c1.getReal());
        assertEquals(2.2, c1.getImaginary());
    }

    @Test
    public void testAdd() {
        Complex c3 = new Complex(0, 5.4);
        Complex c4 = new Complex(-3, 4.2);
        Complex c5 = c3.add(c4);

        // test no change in c3
        assertEquals(0, c3.getReal());
        assertEquals(5.4, c3.getImaginary());
        // test no change in c4
        assertEquals(-3, c4.getReal());
        assertEquals(4.2, c4.getImaginary());

        // test result
        assertEquals(-3, c5.getReal());
        assertEquals(5.4 + 4.2, c5.getImaginary());
    }

    @Test
    public void testMul() {
        Complex c3 = new Complex(0, 5.4);
        Complex c4 = new Complex(-3, 4.2);
        Complex c5 = c3.mul(c4);

        assertEquals(0, c3.getReal());
        assertEquals(5.4, c3.getImaginary());
        // test no change in c4
        assertEquals(-3, c4.getReal());
        assertEquals(4.2, c4.getImaginary());

        // test result
        assertEquals(-(5.4 * 4.2), c5.getReal());
        assertEquals(-3 * 5.4, c5.getImaginary());
    }

    @Test
    public void testString() {
        Complex c1 = new Complex(6.3, 0);
        assertEquals("6.3", c1.toString());

        Complex c2 = new Complex(5, 10.3);
        assertEquals("5.0+10.3i", c2.toString());

        Complex c3 = new Complex(0, 5.4);
        assertEquals("5.4i", c3.toString());

        Complex c4 = new Complex(-3, -4.2);
        assertEquals("-3.0-4.2i", c4.toString());

        Complex c5 = new Complex(0, -5.4);
        assertEquals("-5.4i", c5.toString());
    }

    @Test
    public void testZSequence() {
        Complex r1 = Complex.zSequence(0);
        assertEquals(4, r1.getReal());
        assertEquals(0, r1.getImaginary());

        Complex r = Complex.zSequence(13);
        assertEquals(17, r.getReal());
        assertEquals(-13, r.getImaginary());
        assertEquals("17.0-13.0i", r.toString());
    }
}
