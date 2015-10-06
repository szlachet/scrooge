package com.szlachet.scrooge.business.accounts.boundary;

import com.szlachet.scrooge.business.accounts.entity.Account;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sebastian Szlachetka
 */

@Path("/accounts")
public class AccountsResource {

    @Inject
    private AccountsBoundary ab;
    
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response addAccount(Account account) {
        long accountId = ab.addAccount(account);
        return Response.created(URI.create("/accounts/" + accountId)).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getAccount(@PathParam("id") long id) {
        Account account = ab.getAccount(id);
        return Response.ok(account).build();
    }
    
    
}
