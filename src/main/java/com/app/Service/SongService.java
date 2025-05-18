package com.app.Service;

import com.app.Model.Song;
import com.app.Repository.SongRepository;
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
public class SongService {

    SongRepository songRepository;

    // @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public Song addSong(Song song){
        return songRepository.save(song);
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }
}