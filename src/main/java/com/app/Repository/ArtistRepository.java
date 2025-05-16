package com.app.Repository;

import com.app.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on Artist entities.
 * 
 * This interface extends JpaRepository, providing built-in methods for 
 * interacting with the database, such as saving, finding, deleting, and updating artists.
 * 
 * Spring Data JPA will automatically generate the implementation at runtime.
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}