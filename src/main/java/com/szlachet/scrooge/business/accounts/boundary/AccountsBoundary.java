package com.szlachet.scrooge.business.accounts.boundary;

import com.szlachet.scrooge.business.accounts.entity.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebastian Szlachetka
 */
@Stateless
public class AccountsBoundary {

    @PersistenceContext
    private EntityManager em;
    
    public long addAccount(Account account) {
        return em.merge(account).getId();
    }

    public Account getAccount(long id) {
        return em.find(Account.class, id);
    }

}
