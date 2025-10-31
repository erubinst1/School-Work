// Exercise 4.5

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Playlist {

    private final String TITLE;
    private Set<Song> songs;

    Playlist(String title){
        this.TITLE = title;
        this.songs = new HashSet<>();
    }

    Playlist(String title, Set<Song> songs){
        this.TITLE = title;
        this.songs = new HashSet<>();
        this.songs.addAll(songs);
    }

    Playlist(String title, Song... songs){
        this.TITLE = title;
        this.songs = new HashSet<>();
        for(Song song : songs){
            this.addSong(song);
        }

    }

    //Accessors

    String getTitle(){
        return this.TITLE;
    }

    Set<Song> getSongs(){
        return this.songs;
    }

    /**
     *Overridden hashCode method to produce a code based on the fields and not the object
     *
     * @return hashCode from fields
     */
    @Override
    public int hashCode() {
        return Objects.hash( this.TITLE, this.songs);
    }

    /**
     * Overridden equals method to compare based on fields and not the memory location
     *
     * @param obj input object
     * @return true if the two playlists are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if( !( obj instanceof Playlist)){
            return false;
        }
        Playlist othPlaylist = (Playlist) obj;
        return this.TITLE.equals(othPlaylist.TITLE) && this.songs.equals(othPlaylist.songs);
    }

    /**
     * Overridden toString method to print in a format that is more useful in this context
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "Playlist Title: " + this.TITLE + "\nSongs: " + this.songs.toString();
    }

    /**
     * Returns a boolean indicating if the input song was successfully added to the set of songs
     *
     * @return true if the song was not already present and was added to the set of songs, false otherwise
     */
    boolean addSong(Song s){
        if(this.songs.contains(s)){
            return false;
        }
        return this.songs.add(s);
    }
}
