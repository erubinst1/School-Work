// Exercise 4.5

import java.util.*;

class MusicSystem {

    private ArrayList<User> users;
    private Set<Song> allSongs;

    MusicSystem(){
        this.users = new ArrayList<>();
        this.allSongs = new HashSet<>();
    }

    MusicSystem(ArrayList<User> users, Set<Song> allSongs){
        this.users = users;
        this.allSongs = allSongs;
    }

    //Accessors

    ArrayList<User> getUsers(){
        return this.users;
    }

    Set<Song> getAllSongs(){
        return this.allSongs;
    }

    /**
     * Adds a user to the list of users
     *
     * @param u User to add
     */
    void addUser(User u) {
        if(this.users.contains(u)){
            return;
        }
        if( u == null){
            return;
        }

        this.users.add(u);
        for( Playlist p : u.getPlaylists()){
            allSongs.addAll(p.getSongs());
        }
    }

    /**
     * Attempts to add song s to user u's playlist with the title of playListTitle
     *
     * @param u User input
     * @param playListTitle String title input
     * @param s Song s input
     * @return true if the song was successfully added to the playlist, false otherwise
     */
    boolean addSong(User u, String playListTitle, Song s) {
        for( User us : this.users){
            if( us.equals(u)){
                for( Playlist pl : u.getPlaylists()){
                    if( pl.getTitle().equals(playListTitle)){
                        return pl.addSong(s);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns the song with the largest length out of all the songs that a user has in their playlists
     *
     * @return User key and longest song value
     */
    Map<User, Song> getLongestSong() {
        Map<User, Song> userToLongest = new HashMap<>();

        for( User u : this.users){
            if( u.getPlaylists().isEmpty() || u.getPlaylists() == null){
                continue;
            }
            Optional<Song> longestSong = u.getPlaylists().stream()
                    .filter(p -> p.getSongs() != null && !p.getSongs().isEmpty())
                    .flatMap(p -> p.getSongs().stream())
                    .max(Comparator.comparingInt(Song::getLength));

            //if the optional isn't empty, add to mapA
            longestSong.ifPresent( song -> userToLongest.put(u, song));
        }
        return userToLongest;
    }
}
