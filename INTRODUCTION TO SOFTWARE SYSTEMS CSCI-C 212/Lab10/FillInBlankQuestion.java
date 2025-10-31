class FillInBlankQuestion extends ChoiceQuestion {

    FillInBlankQuestion(String prompt) {
        super(prompt);
    }

    void addChoice(String ans) {
        super.addChoice(ans, true);
    }

    @Override
    boolean isCorrect(String ans) {
        for(String key : super.getChoices().keySet()){
            if(String.valueOf(ans).equals(String.valueOf(key))){
                return true;
            }
        }
        return false;
    }

    @Override
    void setAnswer(String ans) {
        throw new UnsupportedOperationException("FillInBlankQuestion: cannot directly set answer.");
    }

    @Override
    String getAnswer() {
        throw new UnsupportedOperationException("FillInBlankQuestion: cannot directly get answer.");
    }
}