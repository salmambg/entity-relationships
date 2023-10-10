package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private long id;
    private String name;

    @OneToOne
    private Passport passport;

    @Override
    public String toString() {

        return String.format("Student[%s]", name);
    }


}
