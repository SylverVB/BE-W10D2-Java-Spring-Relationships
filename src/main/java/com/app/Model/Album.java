package com.app.Model;

import lombok.*;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.*;
import java.util.List;

/**
 * ORM entity representing an Album.
 * 
 * Albums have a many-to-one relationship with artists, where many albums may be associated with one artist. 
 * They also have a one-to-many relationship with songs, where one album may contain multiple songs. 
 * 
 * Refer to the Artist and Song entities for examples of how @ManyToOne and @OneToMany annotations are used.
 */

@Entity
// For the sake of brevity, the following 4 annotations tell Lombok to generate boilerplate code at compile-time.
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    // The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;
    private String title;

    /**
     * Example of an entity relationship annotation.
     */

    /**
     * Many albums can be associated with one artist.
     * The foreign key 'artist_fk' is stored in the Album table.
     */
    @ManyToOne
    @JoinColumn(name = "artist_fk", nullable = false)
    private Artist artist;

    /**
     * One album can contain many songs.
     * The 'album' field in the Song entity defines the mapped relationship.
     */
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
    }

    /**
     * Custom toString() method that excludes related entities to avoid recursive serialization.
     */
    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                '}';
    }
}