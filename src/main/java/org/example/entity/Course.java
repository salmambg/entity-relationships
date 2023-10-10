package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


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
