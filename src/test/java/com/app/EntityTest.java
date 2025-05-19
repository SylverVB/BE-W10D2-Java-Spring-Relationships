package com.app;

import com.app.Model.Artist;
import com.app.Model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class EntityTest {
    
    /**
     * Verifies that the Album entity contains a ManyToOne relationship with the Artist entity.
     * This ensures that each Album is correctly associated with a single Artist.
     */
    @Test
    public void ManyToOneRelationshipTest() {
        Class<Album> albumClass = Album.class;
        Field[] fields = albumClass.getDeclaredFields();
        boolean annotationFound = false;
        for(Field f : fields) {
            if (f.getName().equals("artist") && f.getType().equals(Artist.class)) {
                Annotation[] annotations = f.getAnnotations();
                for (Annotation a : annotations) {
                    if (a.annotationType() == ManyToOne.class) {
                        annotationFound = true;
                    }
                }
            }
        }

        Assertions.assertTrue(annotationFound);
    }

    /**
     * Verifies that the Album entity contains a OneToMany relationship with the Song entity.
     * This confirms that each Album can be linked to multiple Songs.
     */
    @Test
    public void OneToManyRelationshipTest() {
        Class<Album> albumClass = Album.class;
        Field[] fields = albumClass.getDeclaredFields();
        boolean annotationFound = false;
        for(Field f : fields) {
            if (f.getName().equals("songs") && f.getType().equals(List.class)) {
                Annotation[] annotations = f.getAnnotations();
                for (Annotation a : annotations) {
                    if (a.annotationType() == OneToMany.class) {
                        annotationFound = true;
                    }
                }
            }
        }

        Assertions.assertTrue(annotationFound);
    }
}