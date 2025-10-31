import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;

class DocumentTest {

    @Test
    void testTextDocument(){
        TextDocument t1 = new TextDocument();
        Assertions.assertEquals( 100, t1.numberOfPages());
        Assertions.assertEquals( "Printing text document!", t1.print());
    }

    @Test
    void testSpreadsheetDocument(){
        SpreadsheetDocument s1 = new SpreadsheetDocument();
        Assertions.assertEquals( 50, s1.numberOfPages());
        Assertions.assertEquals( "Printing spreadsheet document!", s1.print());
    }

    @Test
    void testPresentationDocument(){
        PresentationDocument p1 = new PresentationDocument();
        Assertions.assertEquals( 20, p1.numberOfPages());
        Assertions.assertEquals( "Printing the document!", p1.print());
    }

    @Test
    void testPrintingOffice(){
        Assertions.assertEquals(OptionalDouble.of(100.0), PrintingOffice.avgPages(List.of(new TextDocument())));
        Assertions.assertEquals(OptionalDouble.empty(), PrintingOffice.avgPages(List.of()));
        Assertions.assertEquals(OptionalDouble.of(100.0), PrintingOffice.avgPages(List.of(new TextDocument(), new TextDocument(), new TextDocument())));
        Assertions.assertEquals(OptionalDouble.of(60.0), PrintingOffice.avgPages(List.of(new TextDocument(), new PresentationDocument())));
        Assertions.assertEquals(OptionalDouble.of(56.666666666666664), PrintingOffice.avgPages(List.of(new TextDocument(), new SpreadsheetDocument(),new PresentationDocument())));
    }
}