// Exercise 4.5

import java.util.Objects;

class Song {

    private final String TITLE;
    private final String ARTIST;
    private final String GENRE;
    private final int LENGTH;

    Song(String title, String artist, String genre, int length){
        this.TITLE = title;
        this.ARTIST = artist;
        this.GENRE = genre;
        this.LENGTH = length;
    }

    //accessors

    String getTitle(){
        return this.TITLE;
    }

    String getArtist(){
        return this.ARTIST;
    }

    String getGenre(){
        return this.GENRE;
    }

    int getLength(){
        return this.LENGTH;
    }

    /**
     * Overridden hashCode method to produce a code based on the fields and not the object
     *
     * @return hashCode from fields
     */
    @Override
    public int hashCode() {
        return Objects.hash( this.TITLE, this.ARTIST, this.GENRE, this.LENGTH);
    }

    /**
     * Overridden equals method to compare based on fields and not the memory location
     *
     * @param obj input object
     * @return true if the two songs are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Song)){
            return false;
        }
        Song othSong = (Song) obj;
        return this.TITLE.equals(othSong.TITLE)
                && this.ARTIST.equals(othSong.ARTIST)
                && this.GENRE.equals(othSong.GENRE)
                && this.LENGTH == othSong.LENGTH;
    }

    /**
     * Overridden toString method to print in a format that is more useful in this context
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "Title: " + this.TITLE + "\nArtist: " + this.ARTIST + "\nGenre: " + this.GENRE + "\nLength: " + this.LENGTH;
    }
}
