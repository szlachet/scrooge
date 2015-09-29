package com.szlachet.scrooge.business.cashflow.boundary;

import com.szlachet.scrooge.business.cashflow.entity.Expense;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Szlachetka
 */
@Stateless
public class ExpensesBoundary {

    @PersistenceContext
    private EntityManager em;
    
    public long addExpense(Expense expense) {
        return em.merge(expense).getId();
    }

    public Expense getExpense(long id) {
        return em.find(Expense.class, id);
    }
}
