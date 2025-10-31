import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MiniStringBuilderTest {

    @Test
    void testAppend() {
        MiniStringBuilder ms1 = new MiniStringBuilder("Hello");
        ms1.append(" World");
        Assertions.assertEquals("Hello World", ms1.toString());

        MiniStringBuilder ms2 = new MiniStringBuilder("Hello");
        ms2.append("");
        Assertions.assertEquals("Hello", ms2.toString());

        MiniStringBuilder ms3 = new MiniStringBuilder("Hello");
        ms3.append(" World");
        ms3.append("!");
        Assertions.assertEquals("Hello World!", ms3.toString());

        MiniStringBuilder ms4 = new MiniStringBuilder("Hello");
        ms4.append(" @#&$!");
        Assertions.assertEquals("Hello &!", ms4.toString());

        MiniStringBuilder ms5 = new MiniStringBuilder("");
        ms5.append("Hello World");
        Assertions.assertEquals("Hello World", ms5.toString());

        MiniStringBuilder ms6 = new MiniStringBuilder("Hello");
        ms6.append(null);
        Assertions.assertEquals("Hello", ms6.toString());

        MiniStringBuilder ms7 = new MiniStringBuilder("Hello");
        ms7.append(" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals("Hello aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ms7.toString());
    }

    @Test
    void testClear() {
        MiniStringBuilder ms1 = new MiniStringBuilder("Hello");
        Assertions.assertEquals("Hello", ms1.toString());

        ms1.clear();
        Assertions.assertEquals("", ms1.toString());

        MiniStringBuilder ms2 = new MiniStringBuilder(" @#&$!");
        Assertions.assertEquals(" &!", ms2.toString());

        ms2.clear();
        Assertions.assertEquals("", ms2.toString());

        MiniStringBuilder ms3 = new MiniStringBuilder("");
        Assertions.assertEquals("", ms3.toString());

        ms3.clear();
        Assertions.assertEquals("", ms3.toString());
    }

    @Test
    void testToString() {
        MiniStringBuilder ms1 = new MiniStringBuilder("Hello");
        Assertions.assertEquals("Hello", ms1.toString());

        MiniStringBuilder ms2 = new MiniStringBuilder("Hello!@#$%^&*()_+{}|:?><= ");
        Assertions.assertEquals("Hello!&|><= ", ms2.toString());

        MiniStringBuilder ms3 = new MiniStringBuilder(" ");
        Assertions.assertEquals(" ", ms3.toString());

        MiniStringBuilder ms4 = new MiniStringBuilder("");
        Assertions.assertEquals("", ms4.toString());
    }

    @Test
    void testEquals(){
        MiniStringBuilder ms1 = new MiniStringBuilder("Hello");
        MiniStringBuilder ms2 = new MiniStringBuilder("Hello");
        Assertions.assertEquals(ms2, ms1);

        MiniStringBuilder ms3 = new MiniStringBuilder("Hello");
        MiniStringBuilder ms4 = new MiniStringBuilder("Hello((_@#*");
        Assertions.assertEquals(ms4, ms3);

        MiniStringBuilder ms5 = new MiniStringBuilder("Hello");
        Assertions.assertEquals("Hello", ms5.toString());

        MiniStringBuilder ms6 = new MiniStringBuilder("Hello");
        int testInt = 0;
        Assertions.assertNotEquals(testInt, ms6);
    }
}