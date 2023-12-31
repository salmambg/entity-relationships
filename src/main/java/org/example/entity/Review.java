package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private long id;
    private String rating;
    private String description;

    @ManyToOne
    private Course course;
    public Review(Long id, String rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }
    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating, description);
    }
}
