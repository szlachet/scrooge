package com.szlachet.scrooge.business.accounts.entity;

import com.szlachet.scrooge.BaseEntity;
import com.szlachet.scrooge.business.transactions.entity.Transaction;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Sebastian Szlachetka
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ID", "Name"}))
public class Account extends BaseEntity {

    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Balance")
    private BigDecimal balance;
    
    @OneToMany(fetch = EAGER, cascade = {PERSIST, MERGE})
    @JoinColumn(name = "TrxID", referencedColumnName = "ID")
    private Set<Transaction> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public void addTransaction(Transaction transaction) {
        if(transactions == null) {
            transactions = new HashSet<>();
        }
        transactions.add(transaction);
    }
}
