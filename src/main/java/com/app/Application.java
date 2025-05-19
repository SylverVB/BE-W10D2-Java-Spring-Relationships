package com.app;

import com.app.Model.Album;
import com.app.Model.Artist;
import com.app.Model.Song;
import com.app.Service.AlbumService;
import com.app.Service.ArtistService;
import com.app.Service.SongService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.lang.SuppressWarnings;


@SuppressWarnings("unused")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);

        // Retrieve service beans from the application context
        AlbumService albumService = applicationContext.getBean(AlbumService.class);
        ArtistService artistService = applicationContext.getBean(ArtistService.class);
        SongService songService = applicationContext.getBean(SongService.class);

        // Create and persist artist entities
        Artist ar1 = artistService.addArtist(new Artist("artist 1"));
        Artist ar2 = artistService.addArtist(new Artist("artist 2"));

        // Create and persist album entities
        Album al1 = albumService.addAlbum(new Album("album 1"));
        Album al2 = albumService.addAlbum(new Album("album 2"));

        // Create and persist song entities
        Song s1 = songService.addSong(new Song("song 1"));
        Song s2 = songService.addSong(new Song("song 2"));

        // Associate songs with an album
        albumService.addSongToAlbum(al1.getAlbumId(), s1);
        albumService.addSongToAlbum(al1.getAlbumId(), s2);

        // Output all songs and albums
        System.out.println(songService.getAllSongs());
        System.out.println(albumService.getAllAlbums());
    }
}