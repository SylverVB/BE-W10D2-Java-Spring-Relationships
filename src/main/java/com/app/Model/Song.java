package com.app.Model;

import lombok.*;

import jakarta.persistence.*;

/**
 * ORM entity representing a Song.
 * 
 * Songs have a many-to-one relationship with albums, where multiple songs can belong to a single album.
 * This relationship is defined using the @ManyToOne annotation. Spring Data JPA manages the 
 * association between this entity and the corresponding album using a foreign key.
 * 
 * To retrieve the album associated with a song, song.getAlbum() can be used. JPA manages the 
 * join operations between the Song and Album tables.
 */
@Entity
// For the sake of brevity, the following 4 annotations tell Lombok to generate boilerplate code at compile-time.
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    // The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long songId;
    private String title;

    /**
     * Many songs can be associated with one album.
     * 
     * This relationship uses a foreign key named album_fk in the Song table.
     * Spring handles the necessary joins to retrieve the associated album.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_fk")
    private Album album;

    public Song(String title) {
        this.title = title;
    }
    
    /**
     * Custom toString() implementation to avoid recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                '}';
    }
}