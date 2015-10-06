package com.szlachet.scrooge.business.transactions.boundary;

import com.szlachet.scrooge.business.transactions.entity.Expense;
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
@Path("/expenses")
public class ExpensesResource {

    @Inject
    private ExpensesBoundary eb;
    
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response addExpense(Expense expense) {
        long expenseId = eb.addExpense(expense);
        return Response.created(URI.create("/expenses/" + expenseId)).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getExpense(@PathParam("id") long id) {
        Expense expense = eb.getExpense(id);
        return Response.ok(expense).build();
    }
}
