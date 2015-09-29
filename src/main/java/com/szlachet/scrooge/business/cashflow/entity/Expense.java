package com.szlachet.scrooge.business.cashflow.entity;

import com.szlachet.scrooge.BaseEntity;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Sebastian Szlachetka
 */
@Entity
public class Expense extends BaseEntity {

    private BigDecimal price;
    private String description;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(getId());
        hash = 13 * hash + Objects.hashCode(getPrice());
        hash = 13 * hash + Objects.hashCode(getDescription());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Expense other = (Expense) obj;
        if (!Objects.equals(getId(), other.getId())) {
            return false;
        }
        if (!Objects.equals(getPrice(), other.getPrice())) {
            return false;
        }
        if (!Objects.equals(getDescription(), other.getDescription())) {
            return false;
        }
        return true;
    }
    
    
}
