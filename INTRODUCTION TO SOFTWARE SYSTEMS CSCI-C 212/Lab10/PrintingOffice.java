import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

class PrintingOffice {

    /**
     * Calculates the average number of pages across the provided list of Document objects
     *
     * @param lodocs List of Document objects
     * @return Average number of pages across the provided list of Document objects or empty Optional if the list is empty
     */
    static OptionalDouble avgPages(List<Document> lodocs) {
//        if( lodocs.isEmpty()){
//            return OptionalDouble.empty();
//        }
        return lodocs.stream()
                .map(Document::numberOfPages)
                .mapToInt(n -> n)
                .average();
    }

    /**
     * Returns the print method for each Document object in the list provided
     *
     * @param lodocs output of the print method for each Document object in the list provided
     */
    static void printDocuments(List<Document> lodocs) {
        lodocs.forEach(Document::numberOfPages);
    }
}
