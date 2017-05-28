package edu.hanoi.jazz.dao.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hoanghiep on 5/28/17.
 */
@javax.persistence.Entity
@Table(name = "HN_GROUP", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group {

    private String name;
    private int id;

    @Column(name = "name", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
