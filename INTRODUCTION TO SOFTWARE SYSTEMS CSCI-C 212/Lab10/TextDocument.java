class TextDocument implements Document {
    /**
     * Overriden number of pages method to return 100
     *
     * @return int 100
     */
    @Override
    public int numberOfPages(){
        return 100;
    };

    /**
     * Overriden print method to return specific print for a text document
     *
     * @return string representing which type of document is being printed
     */
    @Override
    public String print() {
        return "Printing text document!";
    };
}
