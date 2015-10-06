package com.szlachet.scrooge.business.categories.entity;

import com.szlachet.scrooge.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Sebastian Szlachetka
 */
@Entity
public class Category extends BaseEntity {

    @Column(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
