import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class MusicSystemTest {

    @Test
    void testAddUser(){
        User u11 = new User("test11");
        User u12 = new User("test12");
        User u13 = new User("test13");
        MusicSystem m11 = new MusicSystem();
        m11.addUser(u11);
        m11.addUser(u12);
        m11.addUser(u13);
        Assertions.assertEquals(List.of(u11, u12, u13), m11.getUsers());

        m11.addUser(u11);
        Assertions.assertEquals(List.of(u11, u12, u13), m11.getUsers());

        m11.addUser(null);
        Assertions.assertEquals(List.of(u11, u12, u13), m11.getUsers());

        User u11NameCopy = new User("test11");
        u11NameCopy.createPlaylist("pl1", new Song("a", "b", "c", 1));
        m11.addUser(u11NameCopy);
        Assertions.assertEquals(List.of(u11, u12, u13, u11NameCopy), m11.getUsers());
    }

    @Test
    void testAddSong(){
        User u21 = new User("test21");
        Song s21 = new Song("a", "b", "c", 10);
        Song s22 = new Song("b", "c", "d", 11);
        Song s23 = new Song("c", "d", "e", 12);
        u21.createPlaylist("pl2", s21, s22, s23);
        Assertions.assertEquals(new HashSet<>(List.of(s21, s22, s23)), u21.getPlaylist("pl2").getSongs());

        MusicSystem m21 = new MusicSystem();
        m21.addUser(u21);
        Song s24 = new Song("d", "e", "f", 13);
        m21.addSong( u21, "pl2", s24);
        Assertions.assertEquals(new HashSet<>(List.of(s21, s22, s23, s24)), u21.getPlaylist("pl2").getSongs());


        Song s25 = new Song("e", "f", "g", 14);
        boolean result = m21.addSong(u21, "nonExistentPlaylist", s25);
        Assertions.assertFalse(result);

        result = m21.addSong(u21, "p12", s21);
        Assertions.assertFalse(result);
        Assertions.assertEquals(new HashSet<>(List.of(s21, s22, s23, s24)), u21.getPlaylist("pl2").getSongs());

        result = m21.addSong(u21, "p12", null);
        Assertions.assertFalse(result);
        Assertions.assertEquals(new HashSet<>(List.of(s21, s22, s23, s24)), u21.getPlaylist("pl2").getSongs());
    }

    @Test
    void testGetLongestSong(){
        //User 1
        User u31 = new User("test31");
        Song s31 = new Song("a", "b", "c", 10);
        Song s32 = new Song("b", "c", "d", 11);
        Song s33 = new Song("c", "d", "e", 12);

        u31.createPlaylist("pl31", s31, s32);

        //User 2
        User u32 = new User("test32");

        u32.createPlaylist("pl32");

        //User 3
        User u33 = new User("test33");

        Song s34 = new Song("z", "x", "c", 10);
        Song s35 = new Song("x", "c", "v", 11);
        Song s36 = new Song("c", "v", "b", 12);

        u33.createPlaylist("pl33", s34, s35);
        u33.getPlaylist("pl33").addSong(s36);

        //User 4
        User u34 = new User("test34");

        //Music System
        MusicSystem m31 = new MusicSystem();
        m31.addUser(u31);
        m31.addUser(u32);
        m31.addUser(u33);
        m31.addUser(u34);

        m31.addSong(u31, "pl31", s33);

        MusicSystem m32 = new MusicSystem();

        //Maps
        Map<User, Song> map31Result = new HashMap<>();
        map31Result.put(u31,s33);
        map31Result.put(u33,s36);


        Assertions.assertEquals( map31Result, m31.getLongestSong());
        Assertions.assertEquals(Map.of(), m32.getLongestSong());
    }

}
