import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class BigIntTest {

    @Test
    void testBigInt() {
        BigInt bi1 = new BigInt("42");
        Assertions.assertEquals(List.of(2,4), bi1.getLs());
        Assertions.assertEquals( false, bi1.getIsNeg());

        BigInt bi2 = new BigInt("0420");
        Assertions.assertEquals(List.of(0,2,4), bi2.getLs());
        Assertions.assertEquals( false, bi2.getIsNeg());

        BigInt bi3 = new BigInt("-42");
        Assertions.assertEquals(List.of(2,4), bi3.getLs());
        Assertions.assertEquals( true, bi3.getIsNeg());

        BigInt bi4 = new BigInt("0000420000");
        Assertions.assertEquals(List.of(0,0,0,0,2,4), bi4.getLs());
        Assertions.assertEquals( false, bi4.getIsNeg());

        BigInt bi5 = new BigInt("+42");
        Assertions.assertEquals(List.of(2,4), bi5.getLs());
        Assertions.assertEquals( false, bi5.getIsNeg());

        BigInt bi6 = new BigInt("0");
        Assertions.assertEquals( new BigInt(), bi6);
        Assertions.assertEquals( new BigInt(""), bi6);

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());
        List<Integer> bls1 = new LinkedList<>();
        for (int i = 0; i < 1000; i++) bls1.add(9);
        Assertions.assertEquals(bls1, gi1.getLs());
        Assertions.assertEquals( false, gi1.getIsNeg());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());
        List<Integer> bls2 = new LinkedList<>();
        for (int i = 0; i < 1000; i++) bls2.add(1);
        Assertions.assertEquals(bls2, gi2.getLs());
        Assertions.assertEquals( false, gi2.getIsNeg());
    }

    @Test
    void testEquals() {
        Assertions.assertEquals( new BigInt("42"), new BigInt("42"));
        Assertions.assertEquals( new BigInt("0042"), new BigInt("00042"));
        Assertions.assertEquals( new BigInt("42"), new BigInt("+42"));
        Assertions.assertNotEquals( new BigInt("42"), new BigInt("-42"));
        Assertions.assertEquals( new BigInt("-42"), new BigInt("-42"));
        Assertions.assertNotEquals( new BigInt("420"), new BigInt("422"));

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());

        Assertions.assertEquals( gi1, gi1);
        Assertions.assertNotEquals( gi2, gi1);
    }

    @Test
    void testToString(){
        Assertions.assertEquals( "42", new BigInt("42").toString());
        Assertions.assertEquals( "420", new BigInt("0420").toString());
        Assertions.assertEquals( "-42", new BigInt("-42").toString());
        Assertions.assertEquals( "420000", new BigInt("0000420000").toString());
        Assertions.assertEquals( "42", new BigInt("+42").toString());

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());
        Assertions.assertEquals( sbs1.toString(), gi1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());
        Assertions.assertEquals( sbs2.toString(), gi2.toString());
    }

    @Test
    void testCompareTo(){
        BigInt bi1 = new BigInt("42");
        BigInt bi2 = new BigInt("0420");
        BigInt bi3 = new BigInt("-42");
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi5 = new BigInt("+42");

        Assertions.assertEquals( 1, bi1.compareTo(bi3));
        Assertions.assertEquals( -1, bi3.compareTo(bi1));
        Assertions.assertEquals( 0, bi1.compareTo(bi5));
        Assertions.assertEquals( 1, bi4.compareTo(bi2));

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());

        Assertions.assertEquals( 1, gi1.compareTo(gi2));
        Assertions.assertEquals( 0, gi1.compareTo(gi1));
        Assertions.assertEquals( -1, gi2.compareTo(gi1));
    }

    @Test
    void testCopy(){
        BigInt bi1 = new BigInt("42");
        BigInt bi1c = bi1.copy();
        BigInt bi2 = new BigInt("0420");
        BigInt bi2c = bi2.copy();
        BigInt bi3 = new BigInt("-42");
        BigInt bi3c = bi3.copy();
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi4c = bi4.copy();
        BigInt bi5 = new BigInt("+42");
        BigInt bi5c = bi5.copy();

        Assertions.assertEquals( bi1c, bi1);
        Assertions.assertEquals( bi2c, bi2);
        Assertions.assertEquals( bi3c, bi3);
        Assertions.assertEquals( bi4c, bi4);
        Assertions.assertEquals( bi5c, bi5);

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());
        BigInt gi1c = gi1.copy();

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());
        BigInt gi2c = gi2.copy();

        Assertions.assertEquals( gi1c, gi1);
        Assertions.assertEquals( gi2c, gi2);
    }

    @Test
    void testNegate(){
        BigInt bi1 = new BigInt("42");
        BigInt bi1n = bi1.negate();
        BigInt bi2 = new BigInt("0420");
        BigInt bi2n = bi2.negate();
        BigInt bi3 = new BigInt("-42");
        BigInt bi3n = bi3.negate();
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi4n = bi4.negate();
        BigInt bi5 = new BigInt("+42");
        BigInt bi5n = bi5.negate();

        Assertions.assertEquals( "-42", bi1n.toString());
        Assertions.assertEquals( "-420", bi2n.toString());
        Assertions.assertEquals( "42", bi3n.toString());
        Assertions.assertEquals( "-420000", bi4n.toString());
        Assertions.assertEquals( "-42", bi5n.toString());

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());
        BigInt gi1n = gi1.negate();
        Assertions.assertEquals( "-" + sbs1.toString(), gi1n.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());
        BigInt gi2n = gi2.negate();
        Assertions.assertEquals( "-" + sbs2.toString(), gi2n.toString());
    }

    @Test
    void testAdd(){
        BigInt bi1 = new BigInt("42");
        BigInt bi2 = new BigInt("0420");
        BigInt bi3 = new BigInt("-42");
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi5 = new BigInt("+42");

        Assertions.assertEquals( "84", bi1.add(bi5).toString());
        Assertions.assertEquals( "84", new BigInt("79").add( new BigInt("5")).toString());

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("8");
        BigInt gi1 = new BigInt(sbs1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());

        StringBuilder sbs3 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs3.append("9");
        BigInt gi3 = new BigInt(sbs3.toString());

        Assertions.assertEquals( gi3.toString(), gi1.add(gi2).toString());

        Assertions.assertEquals("84", new BigInt("42").add(new BigInt("42")).toString());
        Assertions.assertEquals("462", new BigInt("42").add(new BigInt("420")).toString());
        Assertions.assertEquals("5000", new BigInt("1000").add(new BigInt("4000")).toString());

        Assertions.assertEquals("0", new BigInt("42").add(new BigInt("-42")).toString());
        Assertions.assertEquals("-378", new BigInt("42").add(new BigInt("-420")).toString());
        Assertions.assertEquals("378", new BigInt("420").add(new BigInt("-42")).toString());

        Assertions.assertEquals("42", new BigInt("42").add(new BigInt("0")).toString());
    }

    @Test
    void testSub(){
        BigInt bi1 = new BigInt("42");
        BigInt bi2 = new BigInt("0420");
        BigInt bi3 = new BigInt("-42");
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi5 = new BigInt("+42");

        Assertions.assertEquals( "0", bi1.sub(bi5).toString());
        Assertions.assertEquals( "2", new BigInt("11").sub( new BigInt("9")).toString());

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());

        StringBuilder sbs3 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs3.append("8");
        BigInt gi3 = new BigInt(sbs3.toString());

        Assertions.assertEquals( gi3.toString(), gi1.sub(gi2).toString());

        Assertions.assertEquals("-84", new BigInt("-42").sub(new BigInt("42")).toString());
        Assertions.assertEquals("-462", new BigInt("-42").sub(new BigInt("420")).toString());
        Assertions.assertEquals("-5000", new BigInt("-1000").sub(new BigInt("4000")).toString());

        Assertions.assertEquals("0", new BigInt("-42").sub(new BigInt("-42")).toString());
        Assertions.assertEquals("378", new BigInt("-42").sub(new BigInt("-420")).toString());
        Assertions.assertEquals("-378", new BigInt("-420").sub(new BigInt("-42")).toString());

        Assertions.assertEquals("-42", new BigInt("-42").sub(new BigInt("0")).toString());
    }

    @Test
    void testMul(){
        BigInt bi1 = new BigInt("42");
        BigInt bi2 = new BigInt("0420");
        BigInt bi3 = new BigInt("-42");
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi5 = new BigInt("+42");

        Assertions.assertEquals( "1764", bi1.mul(bi5).toString());
        Assertions.assertEquals( "-1764", bi1.mul(bi3).toString());

        StringBuilder sbs1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs1.append("9");
        BigInt gi1 = new BigInt(sbs1.toString());

        StringBuilder sbs2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbs2.append("1");
        BigInt gi2 = new BigInt(sbs2.toString());

        Assertions.assertEquals( gi1.toString(), gi2.mul(new BigInt("9")).toString());
    }

    @Test
    void testDiv(){
        BigInt bi1 = new BigInt("42");
        BigInt bi2 = new BigInt("0420");
        BigInt bi3 = new BigInt("-42");
        BigInt bi4 = new BigInt("0000420000");
        BigInt bi5 = new BigInt("+42");

        Assertions.assertEquals( "1", bi1.div(bi5).toString());
        Assertions.assertEquals( "-1", bi1.div(bi3).toString());

        StringBuilder sbi1 = new StringBuilder();
        StringBuilder sbi2 = new StringBuilder();
        for (int i = 0; i < 1000; i++) sbi1.append("9");
        for (int i = 0; i < 1000; i++) sbi2.append("1");
        BigInt gi1 = new BigInt(sbi1.toString());
        BigInt gi2 = new BigInt(sbi2.toString());

        Assertions.assertEquals("9", gi1.div(gi2).toString());

        try {
            bi1.div(new BigInt("0"));
            Assertions.fail("Exception expected");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }
}
