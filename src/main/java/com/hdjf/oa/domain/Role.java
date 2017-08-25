package com.hdjf.oa.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by harrishuang on 2017/8/24.
 *
 * s
 */
@Entity
public class Role  {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id",strategy = "native")
    private Long id;
    private String name;
    @Column(length =100)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
