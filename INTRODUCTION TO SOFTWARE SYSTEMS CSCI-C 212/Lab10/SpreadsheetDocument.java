class SpreadsheetDocument implements Document {
    /**
     * Overriden number of pages method to return 50
     *
     * @return int 50
     */
    @Override
    public int numberOfPages(){
        return 50;
    };

    /**
     * Overriden print method to return specific print for a spreadsheet document
     *
     * @return string representing which type of document is being printed
     */
    @Override
    public String print() {
        return "Printing spreadsheet document!";
    };
}
