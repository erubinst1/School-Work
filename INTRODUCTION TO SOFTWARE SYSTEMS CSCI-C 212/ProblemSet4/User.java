// Exercise 4.5

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class User {

    private final String NAME;
    private List<Playlist> playlists;

    User(String name){
        this.NAME = name;
        playlists = new ArrayList<>();
    }

    //Accessors

    String getName() {
        return this.NAME;
    }

    List<Playlist> getPlaylists(){
        return this.playlists;
    }

    /**
     *Overridden hashCode method to produce a code based on the fields and not the object
     *
     * @return hashCode from fields
     */
    @Override
    public int hashCode() {
        return Objects.hash( this.NAME, this.playlists);
    }

    /**
     * Overridden toString method to print in a format that is more useful in this context
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "User: " + this.NAME + "\nPlaylists: " + this.playlists.toString();
    }

    /**
     * Overridden equals method to compare based on fields and not the memory location
     *
     * @param obj input object
     * @return true if the two playlists are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof User)){
            return false;
        }
        User othUser = (User) obj;
        return this.NAME.equals(othUser.NAME) && this.playlists.equals(othUser.playlists);
    }

    /**
     * Returns a boolean indicating if a playlist was successfully made from a title and variadic song
     *
     * @param t String playlist title
     * @param S Song inputs, variadic
     * @return True if the playlist was created successfully, false if a playlist with the same title already exists
     */
    boolean createPlaylist(String t, Song... S) {
        for( Playlist p : this.playlists){
            if( t.equals(p.getTitle())){
                return false;
            }
        }
        Playlist newPlaylist = new Playlist( t, S);
        this.playlists.add(newPlaylist);
        return true;
    }

    /**
     * Gets the playlist associated to a given title
     *
     * @param title String title
     * @return Playlist associated with the title, null if it doesn't exist
     */
    Playlist getPlaylist(String title) {
        for( Playlist p : this.playlists){
            if( title.equals(p.getTitle())){
                return p;
            }
        }
        return null;
    }
}
