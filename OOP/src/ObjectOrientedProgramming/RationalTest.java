package ObjectOrientedProgramming;
/*import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class RationalTest {
    @Test
    public void test_getNumerator_1() {
        RationalNumbers r = new RationalNumbers(4,5);
        assertEquals(4,r.getNumerator());
    }
    @Test
    public void test_getNumerator_2() {
        RationalNumbers r = new RationalNumbers(7,3);
        assertEquals(7,r.getNumerator());
    }
    @Test
    public void test_getDenumerator_1() {
        RationalNumbers r = new RationalNumbers(4,5);
        assertEquals(5,r.getDenumerator());
    }
    @Test
    public void test_getDenumerator_2() {
        RationalNumbers r = new RationalNumbers(7,3);
        assertEquals(3,r.getDenumerator());
    }
}
*/
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private RationalNumbers r_5_15;
    private RationalNumbers r_24_6;
    private RationalNumbers r_3_7;
    private RationalNumbers r_13_4;
    private RationalNumbers r_20_25;
    private RationalNumbers r_25_20;
    private RationalNumbers r_0_1;

    @Before public void setUp() {
        r_5_15 = new RationalNumbers(5,15);
        r_24_6 = new RationalNumbers(24,6);
        r_3_7  = new RationalNumbers(3,7);
        r_13_4 = new RationalNumbers(13,4);
        r_20_25 = new RationalNumbers(20,25);
        r_0_1 = new RationalNumbers(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
        RationalNumbers r = new RationalNumbers(1,0);
    }

    @Test
    public void test_getNumerator_20_25() {
        assertEquals(4, r_20_25.getNumerator());
    }

    @Test
    public void test_getNumerator_13_4() {
        assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getDenominator_20_25() {
        assertEquals(5, r_20_25.getDenumerator());
    }

    @Test
    public void test_getDenominator_13_4() {
        assertEquals(4, r_13_4.getDenumerator());
    }

    @Test
    public void test_toString_5_15() {
        assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
        assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
        assertEquals("3/7",r_3_7.toString());
    }

    @Test
    public void test_toString_20_25() {
        assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
        assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
        assertEquals(5, RationalNumbers.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
        assertEquals(5, RationalNumbers.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
        assertEquals(6, RationalNumbers.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
        assertEquals(1, RationalNumbers.gcd(17,5));
    }

    @Test
    public void test_gcd_1_1() {
        assertEquals(1, RationalNumbers.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
        assertEquals(5, RationalNumbers.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
        RationalNumbers r = new RationalNumbers(-10,-5);
        assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
        RationalNumbers r = new RationalNumbers(-5,6);
        assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
        RationalNumbers r = new RationalNumbers(7,-8);
        assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
        RationalNumbers r = r_5_15.times(r_3_7);
        assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
        RationalNumbers r = r_3_7.times(r_13_4);
        assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
        RationalNumbers r_m3_1 = new RationalNumbers(-3,1);
        RationalNumbers r_1_m3 = new RationalNumbers(1,-3);
        RationalNumbers r = r_m3_1.times(r_1_m3);
        assertEquals("1",r.toString());
    }

    @Test
    public void test_product_of_r_5_15_and_r_3_7() {
        RationalNumbers r = RationalNumbers.product(r_5_15,r_3_7);
        assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
        RationalNumbers r = RationalNumbers.product(r_3_7,r_13_4);
        assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
        RationalNumbers r_m3_1 = new RationalNumbers(-3,1);
        RationalNumbers r_1_m3 = new RationalNumbers(1,-3);
        RationalNumbers r = RationalNumbers.product(r_m3_1,r_1_m3);
        assertEquals("1",r.toString());
    }


}