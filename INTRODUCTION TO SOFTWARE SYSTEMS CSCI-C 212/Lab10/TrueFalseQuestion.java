class TrueFalseQuestion extends ChoiceQuestion{

    TrueFalseQuestion(String prompt, boolean answer){
        super(prompt);
        if(answer){
            super.addChoice("true", true);
            super.addChoice("false", false);
        }
        else{
            super.addChoice("true", false);
            super.addChoice("false", true);
        }
    }

    @Override
    void addChoice( String answer, boolean isCorrect ) {
        throw new UnsupportedOperationException("TrueFalseQuestion: cannot add choice.");
    }

    @Override
    public String toString(){
        return super.getPrompt() + "\ntrue\nfalse";
    }
}