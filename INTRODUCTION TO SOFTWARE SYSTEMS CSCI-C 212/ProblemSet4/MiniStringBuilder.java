// Exercise 4.23

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MiniStringBuilder {

    private char[] buffer;
    private int bufferChars;

    MiniStringBuilder(){
        this.buffer = new char[20];
        this.bufferChars = 0;
    }

    MiniStringBuilder( String s){
        this.buffer = s.toCharArray();
        this.bufferChars = buffer.length;
    }

    /**
     * Appends the given string onto the end of the current string stored in the buffer
     *
     * @param s input string to be added to the buffer
     */
    void append(String s) {
        if(s == null){
            return;
        }
        char[] newChars = s.toCharArray();
        if(this.buffer.length == 0){
            this.buffer = new char[1];
        }
        while( this.bufferChars + newChars.length > this.buffer.length){
            char[] newBuffer = new char[this.buffer.length*2];
            for(int i = 0; i < this.buffer.length; i++){
                newBuffer[i] = this.buffer[i];
            }
            this.buffer = newBuffer;
        }

        int tempBufferChars = this.bufferChars;
        for(int j = bufferChars; j < tempBufferChars+newChars.length; j++){
            this.buffer[j] = newChars[j-tempBufferChars];
            this.bufferChars++;
        }
    }

    /**
     * Resets this.buffer to the default size of 20 and clears the bufferChars count
     */
    void clear() {
        MiniStringBuilder newBuffer = new MiniStringBuilder();
        this.buffer = newBuffer.buffer;
        this.bufferChars = newBuffer.bufferChars;
    }

    /**
     * Overridden equals method to compare based on fields and not the memory location
     *
     * @param obj input object
     * @return true if the two MiniStringBuilders are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof MiniStringBuilder)){
            return false;
        }
        MiniStringBuilder othMiniStringBuilder = (MiniStringBuilder) obj;
        return this.toString().equals(othMiniStringBuilder.toString());
    }

    /**
     *Overridden hashCode method to produce a code based on the fields and not the object
     *
     * @return hashCode from fields
     */
    @Override
    public int hashCode() {
        return Objects.hash( Arrays.hashCode(this.buffer), this.bufferChars);
    }

    /**
     * Overridden toString method to print in a format that is more useful in this context
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return IntStream.range(0, this.buffer.length)
                .mapToObj(i -> this.buffer[i])
                .filter(c -> Character.isLetterOrDigit(c) || isLogicalSymbol(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Returns a boolean indicating if a character is a logical symbol
     *
     * @return true if the character is a logical symbol, false otherwise;
     */
    private boolean isLogicalSymbol(char c) {
        return c == '&' || c == '|' || c == '!' || c == '>' || c == '<' || c == '=' || c == ' ';
    }
}
