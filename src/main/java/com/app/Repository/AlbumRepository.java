package com.app.Repository;

import com.app.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on Album entities.
 * 
 * This interface extends JpaRepository, providing built-in methods for 
 * interacting with the database, such as saving, finding, deleting, and updating albums.
 * 
 * Spring Data JPA will automatically generate the implementation at runtime.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}