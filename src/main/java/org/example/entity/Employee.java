package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Employee {
    @Id
    private long id;
    private String name;
    @Override
    public String toString() {
        return String.format("Employee[%s]", name);
    }
}
