package com.app.Service;

import com.app.Model.Album;
import com.app.Model.Artist;
import com.app.Repository.ArtistRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class demonstrating ORM functionality for related entities.
 * Uses the @Service stereotype annotation, which is functionally equivalent to @Component.
 */
@Service
@Transactional
public class ArtistService {

    ArtistRepository artistRepository;

    // @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    public Artist addAlbumToArtist(long artistId, Album album){
        Artist artist = artistRepository.findById(artistId).get();
        artist.getAlbums().add(album);
        artistRepository.save(artist);
        return artist;
    }
}