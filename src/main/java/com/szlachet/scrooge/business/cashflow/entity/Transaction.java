package com.szlachet.scrooge.business.cashflow.entity;

import com.szlachet.scrooge.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Sebastian Szlachetka
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TrxType", discriminatorType = DiscriminatorType.STRING)
public class Transaction extends BaseEntity {
    
    @Column(name = "TrxDate")
    private Date trxDate;
    
    @Column(name = "Amount")
    private BigDecimal amount;
    
    @Column(name = "Description")
    private String description;

    @OneToMany(fetch = EAGER, cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CategorieID", referencedColumnName = "ID")
    private Set<Category> categories;

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
   
    public void addCategory(Category category) {
        if(categories == null) {
            categories = new HashSet<>();
        }
        categories.add(category);
    }
}
