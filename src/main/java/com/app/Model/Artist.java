package com.app.Model;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

 /**
 * ORM entity representing an Artist.
 * 
 * Artists have a one-to-many relationship with albums, where one artist can be associated with many albums.
 * This relationship is defined using the @OneToMany annotation. Spring Data JPA manages the mapping 
 * between this entity and the database, including foreign key relationships.
 * 
 * To retrieve the list of albums associated with an artist, artist.getAlbums() can be called. 
 * JPA handles the underlying join operations with the Album table.
 */
@Entity
// For the sake of brevity, the following 4 annotations tell Lombok to generate boilerplate code at compile-time.
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artist {
    // The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistId;
    private String name;

    /**
     * One artist may have multiple albums.
     * 
     * This relationship is mapped using a foreign key named "artist_fk" in the Album table.
     * Spring handles the logic to join the Album and Artist tables when retrieving related data.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
    }

    /**
     * Custom toString() implementation to avoid recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                '}';
    }
}