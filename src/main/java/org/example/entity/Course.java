package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",
                query = "Select  c  From Course c"),
        @NamedQuery(name = "query_get_100_Step_courses",
                query = "Select  c  From Course c where name like '%100 Steps'") })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private Long id;
    @Getter
    private String name;

    @OneToMany(mappedBy = "course")
    @Fetch(FetchMode.JOIN)
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }

}
