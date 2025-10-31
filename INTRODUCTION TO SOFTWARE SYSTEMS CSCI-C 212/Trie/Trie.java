import java.util.*;

class Trie {

    //private static final int TRIE_LETTER_COUNT = 26;
    private static final int ASCII_COUNT = 128;
    private Trie[] trieElements;
    private int count;
    
    Trie() {
        this.trieElements = new Trie[ASCII_COUNT];
        this.count = 0;
    }

    /**
     * Adds a string into the trie.
     * @param s string to add, can contain any ASCII characters.
     */
    void add(String s) {
        if (s.isEmpty()) {
            this.count++;
        } else {
            char c = s.charAt(0);
            int idx = c;
            if (this.trieElements[idx] == null) {
                this.trieElements[idx] = new Trie();
            }
            this.trieElements[idx].add(s.substring(1));
        }
    }

    /**
     * Returns the number of times that a given string is in the Trie.
     * @param s string to check.
     * @return count of s.
     */
    int count(String s) {
        return countHelper(s, this);
    }

    /**
     * Recursive helper method for counting string occurrences.
     * @param s string to check.
     * @param e trie element that we are recursing over.
     */
    private int countHelper(String s, Trie e) {
        if (e == null) {
            return 0;
        } else if (s.isEmpty()) {
            return e.count;
        } else {
            char fst = s.charAt(0);
            int idx = fst;
            return countHelper(s.substring(1), e.trieElements[idx]);
        }
    }

    /**
     * Returns whether a word is in the trie
     * @param s string to check for
     */
    boolean contains(String s){
        return count(s) > 0;
    }

    /**
     * Returns the number of non-null elements in the trie
     * @return number of non-null elements
     */
    private int countNonNullElements(){
        int count = 0;
        for (Trie element : this.trieElements) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Deletes a string s from the Trie. Deleting a string means to
     * completely eradicate s from the string.
     * @param s string to delete.
     */
    void delete(String s) {
        this.deleteHelper(s, this);
    }
    /**
     * Delete recursive helper method
     * @param s string to delete
     * @param t trie that we are recursing over
     * @return true if t can be safely deleted, false otherwise
     */
    private boolean deleteHelper(String s, Trie t) {
        if (s.isEmpty()) {
            if (t.count > 0) {
                t.count = 0;
            }
            return t.countNonNullElements() == 0;
        } else {
            char c = s.charAt(0);
            int idx = c;
            if (deleteHelper(s.substring(1), t.trieElements[idx])) {
                t.trieElements[idx] = null;
                return t.countNonNullElements() == 0;
            } else {
                return false;
            }
        }
    }

    /**
     * Removes n occurrences of s from the Trie. If n is greater the
     * number of occurrences or is Integer.MAX_VALUE, the string is deleted.
     * @param s string to remove.
     * @param n count of s to remove.
     */
    void remove(String s, int n) {
        if (s.isEmpty()) {
            if (n > this.count || n == Integer.MAX_VALUE) {
                this.delete(s);
            } else {
                this.count -= n;
            }
        } else {
            char fst = s.charAt(0);
            int idx = fst;
            this.trieElements[idx].remove(s.substring(1), n);
        }
    }

    /**
     * Adds all input strings to the trie
     * @param s string(s) to add
     */
    void addAll(String... s){
        for(String strings: s){
            this.add(strings);
        }
    }

    /**
     * Returns a map of the strings in the trie to their respective counts, in ascending order by the key
     * @return a map of the strings in the trie to their respective counts, in ascending order by the key
     */
    Map<String, Integer> countMap(){
        Map<String, Integer> stringToCount = new HashMap<>();
        countMapHelper(this, "", stringToCount);
        return stringToCount;
    }

    /**
     * Helper method to map each string in trie with its respective counts, in ascending order
     * @param e the current Trie node
     * @param prefix the accumulated prefix
     * @param map map with word, count pairs
     */
    private void countMapHelper(Trie e, String prefix, Map<String, Integer> map) {
        if (e == null) {
            return;
        }
        if (e.count > 0) {
            map.put(prefix, e.count);
        }
        for (int i = 0; i < ASCII_COUNT; i++) {
            if (e.trieElements[i] != null) {
                char c = (char) i;
                countMapHelper(e.trieElements[i], prefix + c, map);
            }
        }
    }

    /**
     * overridden toString method to return the words in the trie in ascending order as a string seperated by new lines
     * @return words in the trie in ascending order as a string seperated by new lines
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Map<String, Integer> words = countMap();
        List<String> wordsSorted = new ArrayList<>(words.keySet());
        Collections.sort(wordsSorted);

        for(String word : wordsSorted){
            s.append(word).append(", ").append(words.get(word)).append("\n");
        }
        //had to remove trim() lol
        return s.toString();
    }

    /**
     * returns an unordered set of the strings in the trie that start with the given prefix s
     * @param s prefix of strings to collect
     * @return unordered set of the strings in the trie that start with the given prefix s
     */
    Set<String> collectPrefix(String s){
        Set<String> strings = new HashSet<>();
        Trie e = getNodeForPrefix(s);
        if (e != null) {
            collectStrings(e, s, strings);
        }
        return strings;
    }

    /**
     * Helper method to find the node representing the end of the given prefix
     * @param prefix the prefix to search for
     * @return the Trie node at the end of the prefix, or null if the prefix is not in the trie
     */
    private Trie getNodeForPrefix(String prefix) {
        Trie currentNode = this;
        for (char c : prefix.toCharArray()) {
            int idx = c;
            if (currentNode.trieElements[idx] == null) {
                return null;
            }
            currentNode = currentNode.trieElements[idx];
        }
        return currentNode;
    }

    /**
     * Recursive helper method to collect strings from a given prefix and node
     * @param e starting Trie node
     * @param prefix the accumulated prefix
     * @param strings set of strings containing the strings with the given prefix
     */
    private void collectStrings(Trie e, String prefix, Set<String> strings){
        if (e.count > 0) {
            strings.add(prefix);
        }
        for (int i = 0; i < ASCII_COUNT; i++) {
            if (e.trieElements[i] != null) {
                char c = (char) i;
                collectStrings(e.trieElements[i], prefix + c, strings);
            }
        }
    }

    /**
     * returns the kth word in the trie
     * @param k index of word to be returned, from the left
     * @return kth word in the trie
     */
    String kthWord(int k){
        int[] counter = {k};
        return kthWordHelper(this, "", counter);
    }

    /**
     * Recursive helper method to find the kth word in a trie from the left
     * @param e the current Trie node
     * @param prefix the accumulated prefix
     * @param k an array holding the remaining count to find the kth word
     * @return the kth word if found, otherwise null
     */
    private String kthWordHelper(Trie e, String prefix, int[] k) {
        if (e == null) {
            return null;
        }
        if (e.count > 0) {
            k[0] -= e.count;
            if (k[0] <= 0) {
                return prefix;
            }
        }
        for (int i = 0; i < ASCII_COUNT; i++) {
            if (e.trieElements[i] != null) {
                char c = (char) i;
                String kth = kthWordHelper(e.trieElements[i], prefix + c, k);
                if (kth != null) {
                    return kth;
                }
            }
        }
        return null;
    }
}
