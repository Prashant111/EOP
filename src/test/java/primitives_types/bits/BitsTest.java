package primitives_types.bits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.SIZE;
import static org.junit.Assert.assertEquals;

public class BitsTest {
    private Bits bits;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCountNumberOfSetBits1() {
        bits = new Bits(20);
        int actual = bits.countNumberOfSetBits1();
        assertEquals(2, actual);
    }

    @Test
    public void testCountNumberOfSetBits2() {
        bits = new Bits(20);
        int actual = bits.countNumberOfSetBits2();
        assertEquals(2, actual);
    }


    @Test
    public void testCountNumberOfSetBits1_negative_minimum() {
        bits = new Bits(MIN_VALUE);
        int actual = bits.countNumberOfSetBits1();
        assertEquals(1, actual);
    }

    @Test
    public void testCountNumberOfSetBits1_negative() {
        bits = new Bits(-1);
        int actual = bits.countNumberOfSetBits1();
        assertEquals(SIZE, actual);
    }

    @Test
    public void testCountNumberOfSetBits2_negative_minimum() {
        bits = new Bits(MIN_VALUE);
        int actual = bits.countNumberOfSetBits1();
        assertEquals(1, actual);
    }

    @Test
    public void testCountNumberOfSetBits2_negative() {
        bits = new Bits(-1);
        int actual = bits.countNumberOfSetBits1();
        assertEquals(SIZE, actual);
    }

    @Test
    public void tesParity1_odd() {
        bits = new Bits(5);
        int parity = bits.parity1();
        assertEquals(0, parity);
    }

    @Test
    public void testParity1_zero() {
        bits = new Bits(0);
        int parity = bits.parity1();
        assertEquals(0, parity);
    }

    @Test
    public void testParity1_even() {
        bits = new Bits(6);
        int parity = bits.parity1();
        assertEquals(0, parity);
    }

    @Test
    public void testParity1_ofNegativeNumber() {
        bits = new Bits(-98);
        int parity = bits.parity1();
        assertEquals(1, parity);
    }

    @Test
    public void testParity2_odd() {
        bits = new Bits(5);
        int parity = bits.parity2();
        assertEquals(0, parity);
    }

    @Test
    public void testParity2_zero() {
        bits = new Bits(0);
        int parity = bits.parity2();
        assertEquals(0, parity);
    }

    @Test
    public void testParity2_even() {
        bits = new Bits(6);
        int parity = bits.parity2();
        assertEquals(0, parity);
    }

    @Test
    public void testParity2_ofNegativeNumber() {
        bits = new Bits(-98);
        int parity = bits.parity2();
        assertEquals(1, parity);
    }

    @Test
    public void testParity3_odd() {
        bits = new Bits(5);
        int parity = bits.parity3();
        assertEquals(0, parity);
    }

    @Test
    public void testParity3_zero() {
        bits = new Bits(0);
        int parity = bits.parity3();
        assertEquals(0, parity);
    }

    @Test
    public void testParity3_even() {
        bits = new Bits(6);
        int parity = bits.parity3();
        assertEquals(0, parity);
    }

    @Test
    public void testParity3_ofNegativeNumber() {
        bits = new Bits(-98);
        int parity = bits.parity3();
        assertEquals(1, parity);
    }

}