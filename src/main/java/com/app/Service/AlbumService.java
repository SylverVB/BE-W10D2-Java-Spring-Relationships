package com.app.Service;

import com.app.Model.Album;
import com.app.Model.Song;
import com.app.Repository.AlbumRepository;
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
public class AlbumService {

    AlbumRepository albumRepository;

    // @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }

    public Song addSongToAlbum(long albumId, Song song){
        Album album = albumRepository.findById(albumId).get();
        album.getSongs().add(song);
        albumRepository.save(album);
        return song;
    }
}