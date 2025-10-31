import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuestionTest {

    @Test
    void testChoiceQuestion(){
        ChoiceQuestion q1 = new ChoiceQuestion("What is the capital of North Carolina?");
        q1.addChoice("Charlotte", false);
        q1.addChoice("Raleigh", true);
        q1.addChoice("Winston Salem", false);
        q1.addChoice("Columbia", false);

        Assertions.assertEquals( "What is the capital of North Carolina?\nCharlotte\nRaleigh\nWinston Salem\nColumbia", q1.toString());

        Assertions.assertEquals( true, q1.isCorrect("Raleigh"));
        Assertions.assertEquals( false, q1.isCorrect("Charlotte"));
    }

    @Test
    void testTrueFalseQuestion(){
        ChoiceQuestion q2 = new TrueFalseQuestion("The square root of 2 is rational.", false);

        Assertions.assertEquals( "The square root of 2 is rational.\ntrue\nfalse", q2.toString());

        Assertions.assertEquals( false, q2.isCorrect("true"));
        Assertions.assertEquals( true, q2.isCorrect("false"));
    }

    @Test
    void testFillInBlankQuestion(){
        FillInBlankQuestion q3 = new FillInBlankQuestion("2 + 2 = _________");
        q3.addChoice("4");
        q3.addChoice("four");
        q3.addChoice("FOUR");
        q3.addChoice("4.0");

        Assertions.assertEquals( "2 + 2 = _________\n4\nfour\nFOUR\n4.0", q3.toString());

        Assertions.assertEquals( true, q3.isCorrect("4"));
        Assertions.assertEquals( true, q3.isCorrect("four"));
        Assertions.assertEquals( true, q3.isCorrect("FOUR"));
        Assertions.assertEquals( true, q3.isCorrect("4.0"));
        Assertions.assertEquals( false, q3.isCorrect("sqrt(16)"));
    }
}
