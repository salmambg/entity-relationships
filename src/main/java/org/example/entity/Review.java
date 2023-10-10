package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private long id;
    private String rating;
    private String description;


    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating, description);
    }
}
