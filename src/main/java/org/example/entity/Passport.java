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
public class Passport {
    @Id
    private long id;
    private String number;

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
