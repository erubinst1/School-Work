import java.util.LinkedHashMap;
import java.util.Map;

class ChoiceQuestion extends Question{

    private Map<String, Boolean> choices;

    ChoiceQuestion(String prompt){
        super(prompt);
        choices = new LinkedHashMap<>();
    }

    //accessors

    Map<String, Boolean> getChoices(){
        return this.choices;
    }

    /**
     * Inserts answer and isCorrect as an entry into the choices map
     *
     * @param answer string answer
     * @param isCorrect boolean validity of answer
     */
    void addChoice( String answer, boolean isCorrect){
        if(isCorrect) super.setAnswer(answer);
        this.choices.putIfAbsent(answer, isCorrect);
    }

    @Override
    public String toString(){
        StringBuilder answers = new StringBuilder(super.getPrompt());
        for( String key : this.choices.keySet()){
            answers.append("\n").append(key);
        }
        return answers.toString();
    }
}